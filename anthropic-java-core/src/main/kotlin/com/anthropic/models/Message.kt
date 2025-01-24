// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models

import com.anthropic.core.Enum
import com.anthropic.core.ExcludeMissing
import com.anthropic.core.JsonField
import com.anthropic.core.JsonMissing
import com.anthropic.core.JsonValue
import com.anthropic.core.NoAutoDetect
import com.anthropic.core.checkRequired
import com.anthropic.core.immutableEmptyMap
import com.anthropic.core.toImmutable
import com.anthropic.errors.AnthropicInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class Message
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<List<ContentBlock>> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<Model> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
    @JsonProperty("stop_reason")
    @ExcludeMissing
    private val stopReason: JsonField<StopReason> = JsonMissing.of(),
    @JsonProperty("stop_sequence")
    @ExcludeMissing
    private val stopSequence: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("usage") @ExcludeMissing private val usage: JsonField<Usage> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Unique object identifier.
     *
     * The format and length of IDs may change over time.
     */
    fun id(): String = id.getRequired("id")

    /**
     * Content generated by the model.
     *
     * This is an array of content blocks, each of which has a `type` that determines its shape.
     *
     * Example:
     * ```json
     * [{ "type": "text", "text": "Hi, I'm Claude." }]
     * ```
     *
     * If the request input `messages` ended with an `assistant` turn, then the response `content`
     * will continue directly from that last turn. You can use this to constrain the model's output.
     *
     * For example, if the input `messages` were:
     * ```json
     * [
     *   {
     *     "role": "user",
     *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
     *   },
     *   { "role": "assistant", "content": "The best answer is (" }
     * ]
     * ```
     *
     * Then the response `content` might be:
     * ```json
     * [{ "type": "text", "text": "B)" }]
     * ```
     */
    fun content(): List<ContentBlock> = content.getRequired("content")

    /**
     * The model that will complete your prompt.\n\nSee
     * [models](https://docs.anthropic.com/en/docs/models-overview) for additional details and
     * options.
     */
    fun model(): Model = model.getRequired("model")

    /**
     * Conversational role of the generated message.
     *
     * This will always be `"assistant"`.
     */
    fun role(): Role = role.getRequired("role")

    /**
     * The reason that we stopped.
     *
     * This may be one the following values:
     * - `"end_turn"`: the model reached a natural stopping point
     * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
     * - `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
     * - `"tool_use"`: the model invoked one or more tools
     *
     * In non-streaming mode this value is always non-null. In streaming mode, it is null in the
     * `message_start` event and non-null otherwise.
     */
    fun stopReason(): Optional<StopReason> =
        Optional.ofNullable(stopReason.getNullable("stop_reason"))

    /**
     * Which custom stop sequence was generated, if any.
     *
     * This value will be a non-null string if one of your custom stop sequences was generated.
     */
    fun stopSequence(): Optional<String> =
        Optional.ofNullable(stopSequence.getNullable("stop_sequence"))

    /**
     * Object type.
     *
     * For Messages, this is always `"message"`.
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Billing and rate-limit usage.
     *
     * Anthropic's API bills and rate-limits by token counts, as tokens represent the underlying
     * cost to our systems.
     *
     * Under the hood, the API transforms requests into a format suitable for the model. The model's
     * output then goes through a parsing stage before becoming an API response. As a result, the
     * token counts in `usage` will not match one-to-one with the exact visible content of an API
     * request or response.
     *
     * For example, `output_tokens` will be non-zero, even for an empty string response from Claude.
     */
    fun usage(): Usage = usage.getRequired("usage")

    /**
     * Unique object identifier.
     *
     * The format and length of IDs may change over time.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Content generated by the model.
     *
     * This is an array of content blocks, each of which has a `type` that determines its shape.
     *
     * Example:
     * ```json
     * [{ "type": "text", "text": "Hi, I'm Claude." }]
     * ```
     *
     * If the request input `messages` ended with an `assistant` turn, then the response `content`
     * will continue directly from that last turn. You can use this to constrain the model's output.
     *
     * For example, if the input `messages` were:
     * ```json
     * [
     *   {
     *     "role": "user",
     *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
     *   },
     *   { "role": "assistant", "content": "The best answer is (" }
     * ]
     * ```
     *
     * Then the response `content` might be:
     * ```json
     * [{ "type": "text", "text": "B)" }]
     * ```
     */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<ContentBlock>> = content

    /**
     * The model that will complete your prompt.\n\nSee
     * [models](https://docs.anthropic.com/en/docs/models-overview) for additional details and
     * options.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

    /**
     * Conversational role of the generated message.
     *
     * This will always be `"assistant"`.
     */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

    /**
     * The reason that we stopped.
     *
     * This may be one the following values:
     * - `"end_turn"`: the model reached a natural stopping point
     * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
     * - `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
     * - `"tool_use"`: the model invoked one or more tools
     *
     * In non-streaming mode this value is always non-null. In streaming mode, it is null in the
     * `message_start` event and non-null otherwise.
     */
    @JsonProperty("stop_reason")
    @ExcludeMissing
    fun _stopReason(): JsonField<StopReason> = stopReason

    /**
     * Which custom stop sequence was generated, if any.
     *
     * This value will be a non-null string if one of your custom stop sequences was generated.
     */
    @JsonProperty("stop_sequence")
    @ExcludeMissing
    fun _stopSequence(): JsonField<String> = stopSequence

    /**
     * Object type.
     *
     * For Messages, this is always `"message"`.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Billing and rate-limit usage.
     *
     * Anthropic's API bills and rate-limits by token counts, as tokens represent the underlying
     * cost to our systems.
     *
     * Under the hood, the API transforms requests into a format suitable for the model. The model's
     * output then goes through a parsing stage before becoming an API response. As a result, the
     * token counts in `usage` will not match one-to-one with the exact visible content of an API
     * request or response.
     *
     * For example, `output_tokens` will be non-zero, even for an empty string response from Claude.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toParam(): MessageParam =
        MessageParam.builder()
            .content(_content().map { MessageParam.Content.ofBlockParams(it.map { it.toParam() }) })
            .role(_role().map { MessageParam.Role.of(it.toString()) })
            .build()

    private var validated: Boolean = false

    fun validate(): Message = apply {
        if (validated) {
            return@apply
        }

        id()
        content().forEach { it.validate() }
        model()
        role()
        stopReason()
        stopSequence()
        type()
        usage().validate()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String>? = null
        private var content: JsonField<MutableList<ContentBlock>>? = null
        private var model: JsonField<Model>? = null
        private var role: JsonField<Role>? = null
        private var stopReason: JsonField<StopReason>? = null
        private var stopSequence: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var usage: JsonField<Usage>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(message: Message) = apply {
            id = message.id
            content = message.content.map { it.toMutableList() }
            model = message.model
            role = message.role
            stopReason = message.stopReason
            stopSequence = message.stopSequence
            type = message.type
            usage = message.usage
            additionalProperties = message.additionalProperties.toMutableMap()
        }

        /**
         * Unique object identifier.
         *
         * The format and length of IDs may change over time.
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Unique object identifier.
         *
         * The format and length of IDs may change over time.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Content generated by the model.
         *
         * This is an array of content blocks, each of which has a `type` that determines its shape.
         *
         * Example:
         * ```json
         * [{ "type": "text", "text": "Hi, I'm Claude." }]
         * ```
         *
         * If the request input `messages` ended with an `assistant` turn, then the response
         * `content` will continue directly from that last turn. You can use this to constrain the
         * model's output.
         *
         * For example, if the input `messages` were:
         * ```json
         * [
         *   {
         *     "role": "user",
         *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
         *   },
         *   { "role": "assistant", "content": "The best answer is (" }
         * ]
         * ```
         *
         * Then the response `content` might be:
         * ```json
         * [{ "type": "text", "text": "B)" }]
         * ```
         */
        fun content(content: List<ContentBlock>) = content(JsonField.of(content))

        /**
         * Content generated by the model.
         *
         * This is an array of content blocks, each of which has a `type` that determines its shape.
         *
         * Example:
         * ```json
         * [{ "type": "text", "text": "Hi, I'm Claude." }]
         * ```
         *
         * If the request input `messages` ended with an `assistant` turn, then the response
         * `content` will continue directly from that last turn. You can use this to constrain the
         * model's output.
         *
         * For example, if the input `messages` were:
         * ```json
         * [
         *   {
         *     "role": "user",
         *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
         *   },
         *   { "role": "assistant", "content": "The best answer is (" }
         * ]
         * ```
         *
         * Then the response `content` might be:
         * ```json
         * [{ "type": "text", "text": "B)" }]
         * ```
         */
        fun content(content: JsonField<List<ContentBlock>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /**
         * Content generated by the model.
         *
         * This is an array of content blocks, each of which has a `type` that determines its shape.
         *
         * Example:
         * ```json
         * [{ "type": "text", "text": "Hi, I'm Claude." }]
         * ```
         *
         * If the request input `messages` ended with an `assistant` turn, then the response
         * `content` will continue directly from that last turn. You can use this to constrain the
         * model's output.
         *
         * For example, if the input `messages` were:
         * ```json
         * [
         *   {
         *     "role": "user",
         *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
         *   },
         *   { "role": "assistant", "content": "The best answer is (" }
         * ]
         * ```
         *
         * Then the response `content` might be:
         * ```json
         * [{ "type": "text", "text": "B)" }]
         * ```
         */
        fun addContent(content: ContentBlock) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(content)
                }
        }

        /**
         * Content generated by the model.
         *
         * This is an array of content blocks, each of which has a `type` that determines its shape.
         *
         * Example:
         * ```json
         * [{ "type": "text", "text": "Hi, I'm Claude." }]
         * ```
         *
         * If the request input `messages` ended with an `assistant` turn, then the response
         * `content` will continue directly from that last turn. You can use this to constrain the
         * model's output.
         *
         * For example, if the input `messages` were:
         * ```json
         * [
         *   {
         *     "role": "user",
         *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
         *   },
         *   { "role": "assistant", "content": "The best answer is (" }
         * ]
         * ```
         *
         * Then the response `content` might be:
         * ```json
         * [{ "type": "text", "text": "B)" }]
         * ```
         */
        fun addContent(text: TextBlock) = addContent(ContentBlock.ofText(text))

        /**
         * Content generated by the model.
         *
         * This is an array of content blocks, each of which has a `type` that determines its shape.
         *
         * Example:
         * ```json
         * [{ "type": "text", "text": "Hi, I'm Claude." }]
         * ```
         *
         * If the request input `messages` ended with an `assistant` turn, then the response
         * `content` will continue directly from that last turn. You can use this to constrain the
         * model's output.
         *
         * For example, if the input `messages` were:
         * ```json
         * [
         *   {
         *     "role": "user",
         *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
         *   },
         *   { "role": "assistant", "content": "The best answer is (" }
         * ]
         * ```
         *
         * Then the response `content` might be:
         * ```json
         * [{ "type": "text", "text": "B)" }]
         * ```
         */
        fun addContent(toolUse: ToolUseBlock) = addContent(ContentBlock.ofToolUse(toolUse))

        /**
         * The model that will complete your prompt.\n\nSee
         * [models](https://docs.anthropic.com/en/docs/models-overview) for additional details and
         * options.
         */
        fun model(model: Model) = model(JsonField.of(model))

        /**
         * The model that will complete your prompt.\n\nSee
         * [models](https://docs.anthropic.com/en/docs/models-overview) for additional details and
         * options.
         */
        fun model(model: JsonField<Model>) = apply { this.model = model }

        /**
         * The model that will complete your prompt.\n\nSee
         * [models](https://docs.anthropic.com/en/docs/models-overview) for additional details and
         * options.
         */
        fun model(value: String) = apply { model(Model.of(value)) }

        /**
         * Conversational role of the generated message.
         *
         * This will always be `"assistant"`.
         */
        fun role(role: Role) = role(JsonField.of(role))

        /**
         * Conversational role of the generated message.
         *
         * This will always be `"assistant"`.
         */
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /**
         * The reason that we stopped.
         *
         * This may be one the following values:
         * - `"end_turn"`: the model reached a natural stopping point
         * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
         * - `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
         * - `"tool_use"`: the model invoked one or more tools
         *
         * In non-streaming mode this value is always non-null. In streaming mode, it is null in the
         * `message_start` event and non-null otherwise.
         */
        fun stopReason(stopReason: StopReason?) = stopReason(JsonField.ofNullable(stopReason))

        /**
         * The reason that we stopped.
         *
         * This may be one the following values:
         * - `"end_turn"`: the model reached a natural stopping point
         * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
         * - `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
         * - `"tool_use"`: the model invoked one or more tools
         *
         * In non-streaming mode this value is always non-null. In streaming mode, it is null in the
         * `message_start` event and non-null otherwise.
         */
        fun stopReason(stopReason: Optional<StopReason>) = stopReason(stopReason.orElse(null))

        /**
         * The reason that we stopped.
         *
         * This may be one the following values:
         * - `"end_turn"`: the model reached a natural stopping point
         * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
         * - `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
         * - `"tool_use"`: the model invoked one or more tools
         *
         * In non-streaming mode this value is always non-null. In streaming mode, it is null in the
         * `message_start` event and non-null otherwise.
         */
        fun stopReason(stopReason: JsonField<StopReason>) = apply { this.stopReason = stopReason }

        /**
         * Which custom stop sequence was generated, if any.
         *
         * This value will be a non-null string if one of your custom stop sequences was generated.
         */
        fun stopSequence(stopSequence: String?) = stopSequence(JsonField.ofNullable(stopSequence))

        /**
         * Which custom stop sequence was generated, if any.
         *
         * This value will be a non-null string if one of your custom stop sequences was generated.
         */
        fun stopSequence(stopSequence: Optional<String>) = stopSequence(stopSequence.orElse(null))

        /**
         * Which custom stop sequence was generated, if any.
         *
         * This value will be a non-null string if one of your custom stop sequences was generated.
         */
        fun stopSequence(stopSequence: JsonField<String>) = apply {
            this.stopSequence = stopSequence
        }

        /**
         * Object type.
         *
         * For Messages, this is always `"message"`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Object type.
         *
         * For Messages, this is always `"message"`.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /**
         * Billing and rate-limit usage.
         *
         * Anthropic's API bills and rate-limits by token counts, as tokens represent the underlying
         * cost to our systems.
         *
         * Under the hood, the API transforms requests into a format suitable for the model. The
         * model's output then goes through a parsing stage before becoming an API response. As a
         * result, the token counts in `usage` will not match one-to-one with the exact visible
         * content of an API request or response.
         *
         * For example, `output_tokens` will be non-zero, even for an empty string response from
         * Claude.
         */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /**
         * Billing and rate-limit usage.
         *
         * Anthropic's API bills and rate-limits by token counts, as tokens represent the underlying
         * cost to our systems.
         *
         * Under the hood, the API transforms requests into a format suitable for the model. The
         * model's output then goes through a parsing stage before becoming an API response. As a
         * result, the token counts in `usage` will not match one-to-one with the exact visible
         * content of an API request or response.
         *
         * For example, `output_tokens` will be non-zero, even for an empty string response from
         * Claude.
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): Message =
            Message(
                checkRequired("id", id),
                checkRequired("content", content).map { it.toImmutable() },
                checkRequired("model", model),
                checkRequired("role", role),
                checkRequired("stopReason", stopReason),
                checkRequired("stopSequence", stopSequence),
                checkRequired("type", type),
                checkRequired("usage", usage),
                additionalProperties.toImmutable(),
            )
    }

    /**
     * Conversational role of the generated message.
     *
     * This will always be `"assistant"`.
     */
    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ASSISTANT = of("assistant")

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            ASSISTANT,
        }

        enum class Value {
            ASSISTANT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ASSISTANT -> Value.ASSISTANT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ASSISTANT -> Known.ASSISTANT
                else -> throw AnthropicInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Role && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The reason that we stopped.
     *
     * This may be one the following values:
     * - `"end_turn"`: the model reached a natural stopping point
     * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
     * - `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
     * - `"tool_use"`: the model invoked one or more tools
     *
     * In non-streaming mode this value is always non-null. In streaming mode, it is null in the
     * `message_start` event and non-null otherwise.
     */
    class StopReason
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val END_TURN = of("end_turn")

            @JvmField val MAX_TOKENS = of("max_tokens")

            @JvmField val STOP_SEQUENCE = of("stop_sequence")

            @JvmField val TOOL_USE = of("tool_use")

            @JvmStatic fun of(value: String) = StopReason(JsonField.of(value))
        }

        enum class Known {
            END_TURN,
            MAX_TOKENS,
            STOP_SEQUENCE,
            TOOL_USE,
        }

        enum class Value {
            END_TURN,
            MAX_TOKENS,
            STOP_SEQUENCE,
            TOOL_USE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                END_TURN -> Value.END_TURN
                MAX_TOKENS -> Value.MAX_TOKENS
                STOP_SEQUENCE -> Value.STOP_SEQUENCE
                TOOL_USE -> Value.TOOL_USE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                END_TURN -> Known.END_TURN
                MAX_TOKENS -> Known.MAX_TOKENS
                STOP_SEQUENCE -> Known.STOP_SEQUENCE
                TOOL_USE -> Known.TOOL_USE
                else -> throw AnthropicInvalidDataException("Unknown StopReason: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is StopReason && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Object type.
     *
     * For Messages, this is always `"message"`.
     */
    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val MESSAGE = of("message")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            MESSAGE,
        }

        enum class Value {
            MESSAGE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                MESSAGE -> Value.MESSAGE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                MESSAGE -> Known.MESSAGE
                else -> throw AnthropicInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Message && id == other.id && content == other.content && model == other.model && role == other.role && stopReason == other.stopReason && stopSequence == other.stopSequence && type == other.type && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, content, model, role, stopReason, stopSequence, type, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Message{id=$id, content=$content, model=$model, role=$role, stopReason=$stopReason, stopSequence=$stopSequence, type=$type, usage=$usage, additionalProperties=$additionalProperties}"
}
