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
class Completion
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("completion")
    @ExcludeMissing
    private val completion: JsonField<String> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<Model> = JsonMissing.of(),
    @JsonProperty("stop_reason")
    @ExcludeMissing
    private val stopReason: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Unique object identifier.
     *
     * The format and length of IDs may change over time.
     */
    fun id(): String = id.getRequired("id")

    /** The resulting completion up to and excluding the stop sequences. */
    fun completion(): String = completion.getRequired("completion")

    /**
     * The model that will complete your prompt.\n\nSee
     * [models](https://docs.anthropic.com/en/docs/models-overview) for additional details and
     * options.
     */
    fun model(): Model = model.getRequired("model")

    /**
     * The reason that we stopped.
     *
     * This may be one the following values:
     * - `"stop_sequence"`: we reached a stop sequence — either provided by you via the
     *   `stop_sequences` parameter, or a stop sequence built into the model
     * - `"max_tokens"`: we exceeded `max_tokens_to_sample` or the model's maximum
     */
    fun stopReason(): Optional<String> = Optional.ofNullable(stopReason.getNullable("stop_reason"))

    /**
     * Object type.
     *
     * For Text Completions, this is always `"completion"`.
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Unique object identifier.
     *
     * The format and length of IDs may change over time.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The resulting completion up to and excluding the stop sequences. */
    @JsonProperty("completion") @ExcludeMissing fun _completion(): JsonField<String> = completion

    /**
     * The model that will complete your prompt.\n\nSee
     * [models](https://docs.anthropic.com/en/docs/models-overview) for additional details and
     * options.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

    /**
     * The reason that we stopped.
     *
     * This may be one the following values:
     * - `"stop_sequence"`: we reached a stop sequence — either provided by you via the
     *   `stop_sequences` parameter, or a stop sequence built into the model
     * - `"max_tokens"`: we exceeded `max_tokens_to_sample` or the model's maximum
     */
    @JsonProperty("stop_reason") @ExcludeMissing fun _stopReason(): JsonField<String> = stopReason

    /**
     * Object type.
     *
     * For Text Completions, this is always `"completion"`.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Completion = apply {
        if (validated) {
            return@apply
        }

        id()
        completion()
        model()
        stopReason()
        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Completion]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var completion: JsonField<String>? = null
        private var model: JsonField<Model>? = null
        private var stopReason: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completion: Completion) = apply {
            id = completion.id
            this.completion = completion.completion
            model = completion.model
            stopReason = completion.stopReason
            type = completion.type
            additionalProperties = completion.additionalProperties.toMutableMap()
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

        /** The resulting completion up to and excluding the stop sequences. */
        fun completion(completion: String) = completion(JsonField.of(completion))

        /** The resulting completion up to and excluding the stop sequences. */
        fun completion(completion: JsonField<String>) = apply { this.completion = completion }

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
        fun model(value: String) = model(Model.of(value))

        /**
         * The reason that we stopped.
         *
         * This may be one the following values:
         * - `"stop_sequence"`: we reached a stop sequence — either provided by you via the
         *   `stop_sequences` parameter, or a stop sequence built into the model
         * - `"max_tokens"`: we exceeded `max_tokens_to_sample` or the model's maximum
         */
        fun stopReason(stopReason: String?) = stopReason(JsonField.ofNullable(stopReason))

        /**
         * The reason that we stopped.
         *
         * This may be one the following values:
         * - `"stop_sequence"`: we reached a stop sequence — either provided by you via the
         *   `stop_sequences` parameter, or a stop sequence built into the model
         * - `"max_tokens"`: we exceeded `max_tokens_to_sample` or the model's maximum
         */
        fun stopReason(stopReason: Optional<String>) = stopReason(stopReason.orElse(null))

        /**
         * The reason that we stopped.
         *
         * This may be one the following values:
         * - `"stop_sequence"`: we reached a stop sequence — either provided by you via the
         *   `stop_sequences` parameter, or a stop sequence built into the model
         * - `"max_tokens"`: we exceeded `max_tokens_to_sample` or the model's maximum
         */
        fun stopReason(stopReason: JsonField<String>) = apply { this.stopReason = stopReason }

        /**
         * Object type.
         *
         * For Text Completions, this is always `"completion"`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Object type.
         *
         * For Text Completions, this is always `"completion"`.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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

        fun build(): Completion =
            Completion(
                checkRequired("id", id),
                checkRequired("completion", completion),
                checkRequired("model", model),
                checkRequired("stopReason", stopReason),
                checkRequired("type", type),
                additionalProperties.toImmutable(),
            )
    }

    /**
     * Object type.
     *
     * For Text Completions, this is always `"completion"`.
     */
    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val COMPLETION = of("completion")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            COMPLETION,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COMPLETION,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                COMPLETION -> Value.COMPLETION
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws AnthropicInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                COMPLETION -> Known.COMPLETION
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

        return /* spotless:off */ other is Completion && id == other.id && completion == other.completion && model == other.model && stopReason == other.stopReason && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, completion, model, stopReason, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Completion{id=$id, completion=$completion, model=$model, stopReason=$stopReason, type=$type, additionalProperties=$additionalProperties}"
}
