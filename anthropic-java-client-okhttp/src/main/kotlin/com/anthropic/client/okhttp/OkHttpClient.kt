package com.anthropic.client.okhttp

import com.anthropic.core.RequestOptions
import com.anthropic.core.checkRequired
import com.anthropic.core.http.Headers
import com.anthropic.core.http.HttpClient
import com.anthropic.core.http.HttpMethod
import com.anthropic.core.http.HttpRequest
import com.anthropic.core.http.HttpRequestBody
import com.anthropic.core.http.HttpResponse
import com.anthropic.credentials.Credentials
import com.anthropic.errors.AnthropicIoException
import java.io.IOException
import java.io.InputStream
import java.net.Proxy
import java.time.Duration
import java.util.concurrent.CompletableFuture
import okhttp3.Call
import okhttp3.Callback
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.BufferedSink

class OkHttpClient private constructor(
    private val okHttpClient: okhttp3.OkHttpClient,
    private val baseUrl: HttpUrl,

    /**
     * [Credentials] (optional) that may be required to authenticate and
     * authorize requests to an Anthropic service.
     */
    private val credentials: Credentials?)
    : HttpClient {

    private fun getClient(requestOptions: RequestOptions): okhttp3.OkHttpClient {
        val clientBuilder = okHttpClient.newBuilder()

        val logLevel =
            when (System.getenv("ANTHROPIC_LOG")?.lowercase()) {
                "info" -> HttpLoggingInterceptor.Level.BASIC
                "debug" -> HttpLoggingInterceptor.Level.BODY
                else -> null
            }
        if (logLevel != null) {
            clientBuilder.addNetworkInterceptor(
                HttpLoggingInterceptor().setLevel(logLevel).apply {
                    redactHeader("X-Api-Key")
                    redactHeader("Authorization")
                }
            )
        }

        val timeout = requestOptions.timeout
        if (timeout != null) {
            clientBuilder
                .connectTimeout(timeout)
                .readTimeout(timeout)
                .writeTimeout(timeout)
                .callTimeout(if (timeout.seconds == 0L) timeout else timeout.plusSeconds(30))
        }

        return clientBuilder.build()
    }

    override fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): HttpResponse {
        val preparedRequest = credentials?.prepare(request) ?: request
        val signRequest = preparedRequest.resolveUrl()
        val signedRequest = credentials?.sign(signRequest) ?: signRequest
        val okHttpRequest = signedRequest.toRequest()
        val call = getClient(requestOptions).newCall(okHttpRequest)

        return try {
            call.execute().toResponse()
        } catch (e: IOException) {
            throw AnthropicIoException("Request failed", e)
        } finally {
            signedRequest.body?.close()
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val preparedRequest = credentials?.prepare(request) ?: request
        val signRequest = preparedRequest.resolveUrl()
        val signedRequest = credentials?.sign(signRequest) ?: signRequest
        val future = CompletableFuture<HttpResponse>()

        signedRequest.body?.run { future.whenComplete { _, _ -> close() } }

        val call = getClient(requestOptions).newCall(signedRequest.toRequest())
        call.enqueue(
            object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    future.complete(response.toResponse())
                }

                override fun onFailure(call: Call, e: IOException) {
                    future.completeExceptionally(AnthropicIoException("Request failed", e))
                }
            }
        )

        return future
    }

    override fun close() {
        okHttpClient.dispatcher.executorService.shutdown()
        okHttpClient.connectionPool.evictAll()
        okHttpClient.cache?.close()
    }

    private fun HttpRequest.toRequest(): Request {
        var body: RequestBody? = body?.toRequestBody()
        // OkHttpClient always requires a request body for PUT and POST methods.
        if (body == null && (method == HttpMethod.PUT || method == HttpMethod.POST)) {
            body = "".toRequestBody()
        }
        val builder = Request.Builder().url(url ?: "").method(method.name, body)
        headers.names().forEach { name ->
            headers.values(name).forEach { builder.header(name, it) }
        }

        return builder.build()
    }

    /**
     * Creates a new [HttpRequest] with the [HttpRequest.url] property resolved
     * from the base URL, credentials, path segments and query parameters. If
     * the URL is already set, it is not changed.
     *
     * @return The new request instance with the URL property set.
     */
    private fun HttpRequest.resolveUrl(): HttpRequest {
        return toBuilder().url(toUrl()).build()
    }

    private fun HttpRequest.toUrl(): String {
        url?.let {
            return it
        }

        val builder: HttpUrl.Builder =
            credentials?.baseUrl()?.toHttpUrl()?.newBuilder()
                ?: baseUrl.newBuilder()

        pathSegments.forEach(builder::addPathSegment)
        queryParams.keys().forEach { key ->
            queryParams.values(key).forEach { builder.addQueryParameter(key, it) }
        }

        return builder.toString()
    }

    private fun HttpRequestBody.toRequestBody(): RequestBody {
        val mediaType = contentType()?.toMediaType()
        val length = contentLength()

        return object : RequestBody() {
            override fun contentType(): MediaType? = mediaType

            override fun contentLength(): Long = length

            override fun isOneShot(): Boolean = !repeatable()

            override fun writeTo(sink: BufferedSink) = writeTo(sink.outputStream())
        }
    }

    private fun Response.toResponse(): HttpResponse {
        val headers = headers.toHeaders()

        return object : HttpResponse {
            override fun statusCode(): Int = code

            override fun headers(): Headers = headers

            override fun body(): InputStream = body!!.byteStream()

            override fun close() = body!!.close()
        }
    }

    private fun okhttp3.Headers.toHeaders(): Headers {
        val headersBuilder = Headers.builder()
        forEach { (name, value) -> headersBuilder.put(name, value) }
        return headersBuilder.build()
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var baseUrl: HttpUrl? = null
        // The default timeout is 10 minutes.
        private var timeout: Duration = Duration.ofSeconds(600)
        private var proxy: Proxy? = null

        /**
         * [Credentials] that may be required to authenticate and authorize
         * requests to an Anthropic service.
         */
        private var credentials: Credentials? = null

        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl.toHttpUrl() }

        fun timeout(timeout: Duration) = apply { this.timeout = timeout }

        fun proxy(proxy: Proxy?) = apply { this.proxy = proxy }

        /**
         * Sets the credentials to be used to authenticate and authorize the
         * request to an Anthropic service. Implementations of the [Credentials]
         * interface can define the required credentials for a specific service,
         * e.g., Amazon Bedrock.
         *
         * If connecting to the default Anthropic service, these alternative
         * credentials are not required.
         *
         * @param credentials The credentials to be used.
         */
        fun credentials(credentials: Credentials?) = apply {
            this.credentials = credentials
        }

        fun build(): OkHttpClient =
            OkHttpClient(
                okhttp3.OkHttpClient.Builder()
                    .connectTimeout(timeout)
                    .readTimeout(timeout)
                    .writeTimeout(timeout)
                    .callTimeout(if (timeout.seconds == 0L) timeout else timeout.plusSeconds(30))
                    .proxy(proxy)
                    .build(),
                checkRequired("baseUrl", baseUrl),
                credentials,
            )
    }
}