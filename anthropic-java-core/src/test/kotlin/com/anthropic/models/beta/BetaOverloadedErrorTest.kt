// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.beta

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaOverloadedErrorTest {

    @Test
    fun create() {
        val betaOverloadedError = BetaOverloadedError.builder().message("message").build()

        assertThat(betaOverloadedError.message()).isEqualTo("message")
    }
}
