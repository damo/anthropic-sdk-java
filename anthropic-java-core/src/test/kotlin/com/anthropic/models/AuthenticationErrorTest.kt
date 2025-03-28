// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AuthenticationErrorTest {

    @Test
    fun create() {
        val authenticationError = AuthenticationError.builder().message("message").build()

        assertThat(authenticationError.message()).isEqualTo("message")
    }
}
