// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GatewayTimeoutErrorTest {

    @Test
    fun create() {
        val gatewayTimeoutError = GatewayTimeoutError.builder().message("message").build()

        assertThat(gatewayTimeoutError.message()).isEqualTo("message")
    }
}
