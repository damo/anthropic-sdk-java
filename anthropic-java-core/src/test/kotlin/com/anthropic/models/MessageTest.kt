// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageTest {

    @Test
    fun createMessage() {
        val message =
            Message.builder()
                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                .addContent(
                    TextBlock.builder()
                        .addCitation(
                            CitationCharLocation.builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(CitationCharLocation.Type.CHAR_LOCATION)
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(TextBlock.Type.TEXT)
                        .build()
                )
                .model(Model.CLAUDE_3_5_HAIKU_LATEST)
                .role(Message.Role.ASSISTANT)
                .stopReason(Message.StopReason.END_TURN)
                .stopSequence(null)
                .type(Message.Type.MESSAGE)
                .usage(
                    Usage.builder()
                        .cacheCreationInputTokens(2051L)
                        .cacheReadInputTokens(2051L)
                        .inputTokens(2095L)
                        .outputTokens(503L)
                        .build()
                )
                .build()
        assertThat(message).isNotNull
        assertThat(message.id()).isEqualTo("msg_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(message.content())
            .containsExactly(
                ContentBlock.ofText(
                    TextBlock.builder()
                        .addCitation(
                            CitationCharLocation.builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(CitationCharLocation.Type.CHAR_LOCATION)
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(TextBlock.Type.TEXT)
                        .build()
                )
            )
        assertThat(message.model()).isEqualTo(Model.CLAUDE_3_5_HAIKU_LATEST)
        assertThat(message.role()).isEqualTo(Message.Role.ASSISTANT)
        assertThat(message.stopReason()).contains(Message.StopReason.END_TURN)
        assertThat(message.stopSequence()).isEmpty
        assertThat(message.type()).isEqualTo(Message.Type.MESSAGE)
        assertThat(message.usage())
            .isEqualTo(
                Usage.builder()
                    .cacheCreationInputTokens(2051L)
                    .cacheReadInputTokens(2051L)
                    .inputTokens(2095L)
                    .outputTokens(503L)
                    .build()
            )
    }
}
