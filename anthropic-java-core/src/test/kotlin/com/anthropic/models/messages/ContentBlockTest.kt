// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import com.anthropic.core.JsonValue
import com.anthropic.core.jsonMapper
import com.anthropic.errors.AnthropicInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ContentBlockTest {

    @Test
    fun ofText() {
        val text =
            TextBlock.builder()
                .addCitation(
                    CitationCharLocation.builder()
                        .citedText("cited_text")
                        .documentIndex(0L)
                        .documentTitle("document_title")
                        .endCharIndex(0L)
                        .startCharIndex(0L)
                        .build()
                )
                .text("text")
                .build()

        val contentBlock = ContentBlock.ofText(text)

        assertThat(contentBlock.text()).contains(text)
        assertThat(contentBlock.toolUse()).isEmpty
        assertThat(contentBlock.thinking()).isEmpty
        assertThat(contentBlock.redactedThinking()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val contentBlock =
            ContentBlock.ofText(
                TextBlock.builder()
                    .addCitation(
                        CitationCharLocation.builder()
                            .citedText("cited_text")
                            .documentIndex(0L)
                            .documentTitle("document_title")
                            .endCharIndex(0L)
                            .startCharIndex(0L)
                            .build()
                    )
                    .text("text")
                    .build()
            )

        val roundtrippedContentBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contentBlock),
                jacksonTypeRef<ContentBlock>(),
            )

        assertThat(roundtrippedContentBlock).isEqualTo(contentBlock)
    }

    @Test
    fun ofToolUse() {
        val toolUse =
            ToolUseBlock.builder()
                .id("id")
                .input(JsonValue.from(mapOf<String, Any>()))
                .name("x")
                .build()

        val contentBlock = ContentBlock.ofToolUse(toolUse)

        assertThat(contentBlock.text()).isEmpty
        assertThat(contentBlock.toolUse()).contains(toolUse)
        assertThat(contentBlock.thinking()).isEmpty
        assertThat(contentBlock.redactedThinking()).isEmpty
    }

    @Test
    fun ofToolUseRoundtrip() {
        val jsonMapper = jsonMapper()
        val contentBlock =
            ContentBlock.ofToolUse(
                ToolUseBlock.builder()
                    .id("id")
                    .input(JsonValue.from(mapOf<String, Any>()))
                    .name("x")
                    .build()
            )

        val roundtrippedContentBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contentBlock),
                jacksonTypeRef<ContentBlock>(),
            )

        assertThat(roundtrippedContentBlock).isEqualTo(contentBlock)
    }

    @Test
    fun ofThinking() {
        val thinking = ThinkingBlock.builder().signature("signature").thinking("thinking").build()

        val contentBlock = ContentBlock.ofThinking(thinking)

        assertThat(contentBlock.text()).isEmpty
        assertThat(contentBlock.toolUse()).isEmpty
        assertThat(contentBlock.thinking()).contains(thinking)
        assertThat(contentBlock.redactedThinking()).isEmpty
    }

    @Test
    fun ofThinkingRoundtrip() {
        val jsonMapper = jsonMapper()
        val contentBlock =
            ContentBlock.ofThinking(
                ThinkingBlock.builder().signature("signature").thinking("thinking").build()
            )

        val roundtrippedContentBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contentBlock),
                jacksonTypeRef<ContentBlock>(),
            )

        assertThat(roundtrippedContentBlock).isEqualTo(contentBlock)
    }

    @Test
    fun ofRedactedThinking() {
        val redactedThinking = RedactedThinkingBlock.builder().data("data").build()

        val contentBlock = ContentBlock.ofRedactedThinking(redactedThinking)

        assertThat(contentBlock.text()).isEmpty
        assertThat(contentBlock.toolUse()).isEmpty
        assertThat(contentBlock.thinking()).isEmpty
        assertThat(contentBlock.redactedThinking()).contains(redactedThinking)
    }

    @Test
    fun ofRedactedThinkingRoundtrip() {
        val jsonMapper = jsonMapper()
        val contentBlock =
            ContentBlock.ofRedactedThinking(RedactedThinkingBlock.builder().data("data").build())

        val roundtrippedContentBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contentBlock),
                jacksonTypeRef<ContentBlock>(),
            )

        assertThat(roundtrippedContentBlock).isEqualTo(contentBlock)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val contentBlock = jsonMapper().convertValue(testCase.value, jacksonTypeRef<ContentBlock>())

        val e = assertThrows<AnthropicInvalidDataException> { contentBlock.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
