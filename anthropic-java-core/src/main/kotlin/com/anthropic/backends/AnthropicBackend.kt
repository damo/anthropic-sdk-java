package com.anthropic.backends

import com.anthropic.backends.AnthropicBackend.Builder
import com.anthropic.core.http.HttpRequest
import com.anthropic.errors.AnthropicException
import com.anthropic.errors.AnthropicInvalidDataException

/**
 * The Anthropic backend that manages the API key or authorization token
 * credentials and base URL required to access an Anthropic AI model on the
 * Anthropic service.
 *
 * Either the [apiKey] or the [authToken], but not both, must be set (or
 * resolved from the environment). The default value for the base URL is the
 * normal Anthropic API service endpoint, so it only needs to be set if a
 * different service endpoint is required.
 *
 * The credentials can be resolved from environment variables by calling
 * [Builder.fromEnv]. Alternatively, they can be supplied directly to the
 * builder.
 */
class AnthropicBackend private constructor(
    @get:JvmName("apiKey") val apiKey: String?,
    @get:JvmName("authToken") val authToken: String?,
    @get:JvmName("baseUrl") val baseUrl: String,
) : Backend {

    companion object {
        private const val PRODUCTION_URL = "https://api.anthropic.com"
        private const val ANTHROPIC_VERSION = "2023-06-01"
        private const val ENV_API_KEY = "ANTHROPIC_API_KEY"
        private const val ENV_AUTH_TOKEN = "ANTHROPIC_AUTH_TOKEN"
        private const val HEADER_API_KEY = "X-Api-Key"
        private const val HEADER_AUTHORIZATION = "Authorization"
        private const val HEADER_VERSION = "anthropic-version"

        @JvmStatic fun builder() = Builder()

        @JvmStatic fun fromEnv(): AnthropicBackend = builder().fromEnv().build()
    }

    override fun serviceEndpoint(): String = baseUrl

    override fun prepareRequest(request: HttpRequest): HttpRequest {
        if (request.headers.names().contains(HEADER_VERSION)) {
            throw AnthropicInvalidDataException(
                "Request already prepared for Anthropic.")
        }

        return request.toBuilder()
            .putHeader(HEADER_VERSION, ANTHROPIC_VERSION)
            .build()
    }

    override fun authorizeRequest(request: HttpRequest): HttpRequest {
        if (request.headers.names().contains(HEADER_API_KEY )
                || request.headers.names().contains(HEADER_AUTHORIZATION)) {
            throw AnthropicInvalidDataException(
                "Request already authorized for Anthropic.")
        }

        return request.toBuilder()
            .apply {
                // Only one of these two properties will be set, so only one
                // header will be added.
                apiKey?.let { putHeader(HEADER_API_KEY, it) }
                authToken?.let { putHeader(HEADER_AUTHORIZATION, "Bearer $it") }
            }.build()
    }

    override fun close() {}

    /**
     * A builder for a [AnthropicBackend] used to connect an Anthropic client to
     * an Anthropic backend service.
     *
     * The authorization credentials can be extracted from the environment and
     * set on the builder by calling [fromEnv] before calling [build] to create
     * the [AnthropicBackend]. Alternatively, set the credentials explicitly via
     * [apiKey] or [authToken] before calling [build].
     */
    class Builder internal constructor() {
        private var apiKey: String? = null
        private var authToken: String? = null
        private var baseUrl: String = PRODUCTION_URL

        fun fromEnv() = apply {
            apiKey = System.getenv(ENV_API_KEY)
            authToken = System.getenv(ENV_AUTH_TOKEN)

            if (apiKey == null && authToken == null) {
                throw AnthropicException(
                    "No API key set in $ENV_API_KEY environment variable and " +
                            "no authorization token set in $ENV_AUTH_TOKEN " +
                            "environment variable. Please set exactly one.")
            }
        }

        fun apiKey(apiKey: String?) = apply { this.apiKey = apiKey }

        fun authToken(authToken: String?) = apply { this.authToken = authToken }

        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl }

        fun build(): AnthropicBackend {
            // Using "IllegalStateException", as that is what is used in the
            // "build()" functions of the other backends, where "checkRequired"
            // is called.
            if (apiKey == null && authToken == null) {
                throw IllegalStateException(
                    "Neither the API key nor the authorization token is set. " +
                            "Please set exactly one.")
            }
            if (apiKey != null && authToken != null) {
                throw IllegalStateException(
                    "Both the API key and the authorization token are set. " +
                            "Please set exactly one.")
            }

            return AnthropicBackend(apiKey, authToken, baseUrl)
        }
    }
}