// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import com.anthropic.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolUseBlockParamTest {

    @Test
    fun create() {
        val toolUseBlockParam =
            ToolUseBlockParam.builder()
                .id("id")
                .input(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .cacheControl(CacheControlEphemeral.builder().build())
                .build()

        assertThat(toolUseBlockParam.id()).isEqualTo("id")
        assertThat(toolUseBlockParam._input()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(toolUseBlockParam.name()).isEqualTo("name")
        assertThat(toolUseBlockParam.cacheControl())
            .contains(CacheControlEphemeral.builder().build())
    }
}
