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

internal class ToolUnionTest {

    @Test
    fun ofTool() {
        val tool =
            Tool.builder()
                .inputSchema(
                    Tool.InputSchema.builder()
                        .properties(
                            JsonValue.from(
                                mapOf(
                                    "location" to
                                        mapOf(
                                            "description" to
                                                "The city and state, e.g. San Francisco, CA",
                                            "type" to "string",
                                        ),
                                    "unit" to
                                        mapOf(
                                            "description" to
                                                "Unit for the output - one of (celsius, fahrenheit)",
                                            "type" to "string",
                                        ),
                                )
                            )
                        )
                        .build()
                )
                .name("name")
                .cacheControl(CacheControlEphemeral.builder().build())
                .description("Get the current weather in a given location")
                .build()

        val toolUnion = ToolUnion.ofTool(tool)

        assertThat(toolUnion.tool()).contains(tool)
        assertThat(toolUnion.bash20250124()).isEmpty
        assertThat(toolUnion.textEditor20250124()).isEmpty
    }

    @Test
    fun ofToolRoundtrip() {
        val jsonMapper = jsonMapper()
        val toolUnion =
            ToolUnion.ofTool(
                Tool.builder()
                    .inputSchema(
                        Tool.InputSchema.builder()
                            .properties(
                                JsonValue.from(
                                    mapOf(
                                        "location" to
                                            mapOf(
                                                "description" to
                                                    "The city and state, e.g. San Francisco, CA",
                                                "type" to "string",
                                            ),
                                        "unit" to
                                            mapOf(
                                                "description" to
                                                    "Unit for the output - one of (celsius, fahrenheit)",
                                                "type" to "string",
                                            ),
                                    )
                                )
                            )
                            .build()
                    )
                    .name("name")
                    .cacheControl(CacheControlEphemeral.builder().build())
                    .description("Get the current weather in a given location")
                    .build()
            )

        val roundtrippedToolUnion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolUnion),
                jacksonTypeRef<ToolUnion>(),
            )

        assertThat(roundtrippedToolUnion).isEqualTo(toolUnion)
    }

    @Test
    fun ofBash20250124() {
        val bash20250124 =
            ToolBash20250124.builder().cacheControl(CacheControlEphemeral.builder().build()).build()

        val toolUnion = ToolUnion.ofBash20250124(bash20250124)

        assertThat(toolUnion.tool()).isEmpty
        assertThat(toolUnion.bash20250124()).contains(bash20250124)
        assertThat(toolUnion.textEditor20250124()).isEmpty
    }

    @Test
    fun ofBash20250124Roundtrip() {
        val jsonMapper = jsonMapper()
        val toolUnion =
            ToolUnion.ofBash20250124(
                ToolBash20250124.builder()
                    .cacheControl(CacheControlEphemeral.builder().build())
                    .build()
            )

        val roundtrippedToolUnion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolUnion),
                jacksonTypeRef<ToolUnion>(),
            )

        assertThat(roundtrippedToolUnion).isEqualTo(toolUnion)
    }

    @Test
    fun ofTextEditor20250124() {
        val textEditor20250124 =
            ToolTextEditor20250124.builder()
                .cacheControl(CacheControlEphemeral.builder().build())
                .build()

        val toolUnion = ToolUnion.ofTextEditor20250124(textEditor20250124)

        assertThat(toolUnion.tool()).isEmpty
        assertThat(toolUnion.bash20250124()).isEmpty
        assertThat(toolUnion.textEditor20250124()).contains(textEditor20250124)
    }

    @Test
    fun ofTextEditor20250124Roundtrip() {
        val jsonMapper = jsonMapper()
        val toolUnion =
            ToolUnion.ofTextEditor20250124(
                ToolTextEditor20250124.builder()
                    .cacheControl(CacheControlEphemeral.builder().build())
                    .build()
            )

        val roundtrippedToolUnion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolUnion),
                jacksonTypeRef<ToolUnion>(),
            )

        assertThat(roundtrippedToolUnion).isEqualTo(toolUnion)
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
        val toolUnion = jsonMapper().convertValue(testCase.value, jacksonTypeRef<ToolUnion>())

        val e = assertThrows<AnthropicInvalidDataException> { toolUnion.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
