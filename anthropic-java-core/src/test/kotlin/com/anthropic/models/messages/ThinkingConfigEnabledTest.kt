// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThinkingConfigEnabledTest {

    @Test
    fun create() {
        val thinkingConfigEnabled = ThinkingConfigEnabled.builder().budgetTokens(1024L).build()

        assertThat(thinkingConfigEnabled.budgetTokens()).isEqualTo(1024L)
    }
}
