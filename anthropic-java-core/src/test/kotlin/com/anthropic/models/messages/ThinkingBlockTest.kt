// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThinkingBlockTest {

    @Test
    fun create() {
        val thinkingBlock =
            ThinkingBlock.builder().signature("signature").thinking("thinking").build()

        assertThat(thinkingBlock.signature()).isEqualTo("signature")
        assertThat(thinkingBlock.thinking()).isEqualTo("thinking")
    }
}
