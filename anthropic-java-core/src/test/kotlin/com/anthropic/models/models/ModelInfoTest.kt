// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.models

import com.anthropic.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelInfoTest {

    @Test
    fun create() {
        val modelInfo =
            ModelInfo.builder()
                .id("claude-3-7-sonnet-20250219")
                .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                .displayName("Claude 3.7 Sonnet")
                .build()

        assertThat(modelInfo.id()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(modelInfo.createdAt()).isEqualTo(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
        assertThat(modelInfo.displayName()).isEqualTo("Claude 3.7 Sonnet")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val modelInfo =
            ModelInfo.builder()
                .id("claude-3-7-sonnet-20250219")
                .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                .displayName("Claude 3.7 Sonnet")
                .build()

        val roundtrippedModelInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(modelInfo),
                jacksonTypeRef<ModelInfo>(),
            )

        assertThat(roundtrippedModelInfo).isEqualTo(modelInfo)
    }
}
