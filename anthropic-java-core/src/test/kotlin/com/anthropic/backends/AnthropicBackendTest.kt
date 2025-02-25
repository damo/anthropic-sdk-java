package com.anthropic.backends

import com.anthropic.core.http.HttpMethod
import com.anthropic.core.http.HttpRequest
import com.anthropic.errors.AnthropicInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class AnthropicBackendTest {
    companion object {
        private const val PRODUCTION_URL = "https://api.anthropic.com"
        private const val OTHER_URL = "https://api.example.com"
        private const val API_KEY = "test-api-key-123456789"
        private const val AUTH_TOKEN = "test-auth-token-987654321"
    }

    @Test
    fun serviceEndpointExplicit() {
        val backend = createBackend(null, AUTH_TOKEN, OTHER_URL)

        assertThat(backend.serviceEndpoint()).isEqualTo(OTHER_URL)
    }

    @Test
    fun serviceEndpointDefault() {
        val backend = createBackend(API_KEY, null, null)

        assertThat(backend.serviceEndpoint()).isEqualTo(PRODUCTION_URL)
    }

    @Test
    fun prepareRequest() {
        val backend = createBackend()
        val request = createRequest()
        val headersCount = request.headers.names().size
        val preparedRequest = backend.prepareRequest(request)

        assertThat(request.headers.values("anthropic-version")).isEmpty()

        assertThat(preparedRequest.headers.names().size)
            .isEqualTo(headersCount + 1)
        assertThat(preparedRequest.headers.values("anthropic-version").size)
            .isEqualTo(1)
        assertThat(preparedRequest.headers.values("anthropic-version")[0])
            .isEqualTo("2023-06-01")
    }

    @Test
    fun prepareRequestAlreadyPrepared() {
        val backend = createBackend()
        val preparedRequest = backend.prepareRequest(createRequest())

        assertThatThrownBy { backend.prepareRequest(preparedRequest) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("Request already prepared")
    }

    @Test
    fun authorizeRequestWithApiKey() {
        val backend = createBackend(API_KEY, null, null)
        // It is not necessary to call "prepareRequest" or resolve the URL
        // before calling "authorizeRequest" on an "AnthropicBackend".
        val request = createRequest()
        val headersCount = request.headers.names().size
        val authorizedRequest = backend.authorizeRequest(request)

        assertThat(request.headers.values("X-Api-Key")).isEmpty()
        assertThat(request.headers.values("Authorization")).isEmpty()

        assertThat(authorizedRequest.headers.names().size)
            .isEqualTo(headersCount + 1)
        assertThat(authorizedRequest.headers.values("X-Api-Key").size)
            .isEqualTo(1)
        assertThat(authorizedRequest.headers.values("X-Api-Key")[0])
            .isEqualTo(API_KEY)
        assertThat(authorizedRequest.headers.values("Authorization")).isEmpty()
    }

    @Test
    fun authorizeRequestAuthToken() {
        val backend = createBackend(null, AUTH_TOKEN, null)
        val request = createRequest()
        val headersCount = request.headers.names().size
        val authorizedRequest = backend.authorizeRequest(request)

        assertThat(request.headers.values("X-Api-Key")).isEmpty()
        assertThat(request.headers.values("Authorization")).isEmpty()

        assertThat(authorizedRequest.headers.names().size)
            .isEqualTo(headersCount + 1)
        assertThat(authorizedRequest.headers.values("Authorization").size)
            .isEqualTo(1)
        assertThat(authorizedRequest.headers.values("Authorization")[0])
            .isEqualTo("Bearer $AUTH_TOKEN")
        assertThat(authorizedRequest.headers.values("X-Api-Key")).isEmpty()
    }

    @Test
    fun authorizeRequestAlreadyAuthorizedWithApiKey() {
        val backend = createBackend(API_KEY, null, null)
        val authorizedRequest = backend.authorizeRequest(createRequest())

        assertThatThrownBy { backend.authorizeRequest(authorizedRequest) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("Request already authorized")
    }

    @Test
    fun authorizeRequestAlreadyAuthorizedWithAuthToken() {
        val backend = createBackend(null, AUTH_TOKEN, null)
        val authorizedRequest = backend.authorizeRequest(createRequest())

        assertThatThrownBy { backend.authorizeRequest(authorizedRequest) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("Request already authorized")
    }

    @Test
    fun builderApiKeyAndAuthTokenBothSet() {
        assertThatThrownBy { createBackend(API_KEY, AUTH_TOKEN, null) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessageStartingWith("Both")
    }

    @Test
    fun builderApiKeyAndAuthTokenBothNotSet() {
        assertThatThrownBy { createBackend(null, null, null) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessageStartingWith("Neither")
    }

    private fun createBackend(): AnthropicBackend =
        createBackend(API_KEY, null, null)

    /**
     * Creates a new Anthropic backend test fixture.
     *
     * @param apiKey May be `null` only if [authToken] is non-`null`.
     * @param authToken May be `null` only if [apiKey] is non-`null`.
     * @param baseUrl If `null`, the default production URL is assumed.
     */
    private fun createBackend(
            apiKey: String?, authToken: String?, baseUrl: String?)
            : AnthropicBackend = AnthropicBackend.builder()
        .apiKey(apiKey)
        .authToken(authToken)
        .apply { if (baseUrl != null) { baseUrl(baseUrl) } }
        .build()

    private fun createRequest(vararg pathSegments: String): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.POST) // A method is required.
            .build()
}