// File generated from our OpenAPI spec by Stainless.

package com.anthropic.services.blocking

import com.anthropic.TestServerExtension
import com.anthropic.client.okhttp.AnthropicOkHttpClient
import com.anthropic.core.JsonValue
import com.anthropic.models.CacheControlEphemeral
import com.anthropic.models.CitationCharLocationParam
import com.anthropic.models.MessageCountTokensParams
import com.anthropic.models.MessageCreateParams
import com.anthropic.models.MessageParam
import com.anthropic.models.Metadata
import com.anthropic.models.Model
import com.anthropic.models.TextBlockParam
import com.anthropic.models.Tool
import com.anthropic.models.ToolChoiceAuto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MessageServiceTest {

    @Test
    fun callCreate() {
        val client =
            AnthropicOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("my-anthropic-api-key")
                .build()
        val messageService = client.messages()
        val message =
            messageService.create(
                MessageCreateParams.builder()
                    .maxTokens(1024L)
                    .addMessage(
                        MessageParam.builder()
                            .content("Hello, world")
                            .role(MessageParam.Role.USER)
                            .build()
                    )
                    .model(Model.CLAUDE_3_5_HAIKU_LATEST)
                    .metadata(
                        Metadata.builder().userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b").build()
                    )
                    .addStopSequence("string")
                    .systemOfTextBlockParams(
                        listOf(
                            TextBlockParam.builder()
                                .text("Today's date is 2024-06-01.")
                                .type(TextBlockParam.Type.TEXT)
                                .cacheControl(
                                    CacheControlEphemeral.builder()
                                        .type(CacheControlEphemeral.Type.EPHEMERAL)
                                        .build()
                                )
                                .addCitation(
                                    CitationCharLocationParam.builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("x")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .type(CitationCharLocationParam.Type.CHAR_LOCATION)
                                        .build()
                                )
                                .build()
                        )
                    )
                    .temperature(1.0)
                    .toolChoice(
                        ToolChoiceAuto.builder()
                            .type(ToolChoiceAuto.Type.AUTO)
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        Tool.builder()
                            .inputSchema(
                                Tool.InputSchema.builder()
                                    .type(Tool.InputSchema.Type.OBJECT)
                                    .properties(
                                        JsonValue.from(
                                            mapOf(
                                                "location" to
                                                    mapOf(
                                                        "description" to
                                                            "The city and state, e.g. San Francisco, CA",
                                                        "type" to "string"
                                                    ),
                                                "unit" to
                                                    mapOf(
                                                        "description" to
                                                            "Unit for the output - one of (celsius, fahrenheit)",
                                                        "type" to "string"
                                                    )
                                            )
                                        )
                                    )
                                    .build()
                            )
                            .name("name")
                            .cacheControl(
                                CacheControlEphemeral.builder()
                                    .type(CacheControlEphemeral.Type.EPHEMERAL)
                                    .build()
                            )
                            .description("Get the current weather in a given location")
                            .build()
                    )
                    .topK(5L)
                    .topP(0.7)
                    .build()
            )
        println(message)
        message.validate()
    }

    @Test
    fun callCreateStreaming() {
        val client =
            AnthropicOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("my-anthropic-api-key")
                .build()
        val messageService = client.messages()

        val messageStream =
            messageService.createStreaming(
                MessageCreateParams.builder()
                    .maxTokens(1024L)
                    .addMessage(
                        MessageParam.builder()
                            .content("Hello, world")
                            .role(MessageParam.Role.USER)
                            .build()
                    )
                    .model(Model.CLAUDE_3_5_HAIKU_LATEST)
                    .metadata(
                        Metadata.builder().userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b").build()
                    )
                    .addStopSequence("string")
                    .systemOfTextBlockParams(
                        listOf(
                            TextBlockParam.builder()
                                .text("Today's date is 2024-06-01.")
                                .type(TextBlockParam.Type.TEXT)
                                .cacheControl(
                                    CacheControlEphemeral.builder()
                                        .type(CacheControlEphemeral.Type.EPHEMERAL)
                                        .build()
                                )
                                .addCitation(
                                    CitationCharLocationParam.builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("x")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .type(CitationCharLocationParam.Type.CHAR_LOCATION)
                                        .build()
                                )
                                .build()
                        )
                    )
                    .temperature(1.0)
                    .toolChoice(
                        ToolChoiceAuto.builder()
                            .type(ToolChoiceAuto.Type.AUTO)
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        Tool.builder()
                            .inputSchema(
                                Tool.InputSchema.builder()
                                    .type(Tool.InputSchema.Type.OBJECT)
                                    .properties(
                                        JsonValue.from(
                                            mapOf(
                                                "location" to
                                                    mapOf(
                                                        "description" to
                                                            "The city and state, e.g. San Francisco, CA",
                                                        "type" to "string"
                                                    ),
                                                "unit" to
                                                    mapOf(
                                                        "description" to
                                                            "Unit for the output - one of (celsius, fahrenheit)",
                                                        "type" to "string"
                                                    )
                                            )
                                        )
                                    )
                                    .build()
                            )
                            .name("name")
                            .cacheControl(
                                CacheControlEphemeral.builder()
                                    .type(CacheControlEphemeral.Type.EPHEMERAL)
                                    .build()
                            )
                            .description("Get the current weather in a given location")
                            .build()
                    )
                    .topK(5L)
                    .topP(0.7)
                    .build()
            )

        messageStream.use {
            messageStream.stream().forEach {
                println(it)
                it.validate()
            }
        }
    }

    @Test
    fun callCountTokens() {
        val client =
            AnthropicOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("my-anthropic-api-key")
                .build()
        val messageService = client.messages()
        val messageTokensCount =
            messageService.countTokens(
                MessageCountTokensParams.builder()
                    .addMessage(
                        MessageParam.builder()
                            .content("string")
                            .role(MessageParam.Role.USER)
                            .build()
                    )
                    .model(Model.CLAUDE_3_5_HAIKU_LATEST)
                    .systemOfTextBlockParams(
                        listOf(
                            TextBlockParam.builder()
                                .text("Today's date is 2024-06-01.")
                                .type(TextBlockParam.Type.TEXT)
                                .cacheControl(
                                    CacheControlEphemeral.builder()
                                        .type(CacheControlEphemeral.Type.EPHEMERAL)
                                        .build()
                                )
                                .addCitation(
                                    CitationCharLocationParam.builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("x")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .type(CitationCharLocationParam.Type.CHAR_LOCATION)
                                        .build()
                                )
                                .build()
                        )
                    )
                    .toolChoice(
                        ToolChoiceAuto.builder()
                            .type(ToolChoiceAuto.Type.AUTO)
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        Tool.builder()
                            .inputSchema(
                                Tool.InputSchema.builder()
                                    .type(Tool.InputSchema.Type.OBJECT)
                                    .properties(
                                        JsonValue.from(
                                            mapOf(
                                                "location" to
                                                    mapOf(
                                                        "description" to
                                                            "The city and state, e.g. San Francisco, CA",
                                                        "type" to "string"
                                                    ),
                                                "unit" to
                                                    mapOf(
                                                        "description" to
                                                            "Unit for the output - one of (celsius, fahrenheit)",
                                                        "type" to "string"
                                                    )
                                            )
                                        )
                                    )
                                    .build()
                            )
                            .name("name")
                            .cacheControl(
                                CacheControlEphemeral.builder()
                                    .type(CacheControlEphemeral.Type.EPHEMERAL)
                                    .build()
                            )
                            .description("Get the current weather in a given location")
                            .build()
                    )
                    .build()
            )
        println(messageTokensCount)
        messageTokensCount.validate()
    }
}
