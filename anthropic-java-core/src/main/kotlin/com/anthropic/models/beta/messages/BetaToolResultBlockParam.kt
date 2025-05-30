// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.beta.messages

import com.anthropic.core.BaseDeserializer
import com.anthropic.core.BaseSerializer
import com.anthropic.core.ExcludeMissing
import com.anthropic.core.JsonField
import com.anthropic.core.JsonMissing
import com.anthropic.core.JsonValue
import com.anthropic.core.allMaxBy
import com.anthropic.core.checkRequired
import com.anthropic.core.getOrThrow
import com.anthropic.errors.AnthropicInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BetaToolResultBlockParam
private constructor(
    private val toolUseId: JsonField<String>,
    private val type: JsonValue,
    private val cacheControl: JsonField<BetaCacheControlEphemeral>,
    private val content: JsonField<Content>,
    private val isError: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("tool_use_id")
        @ExcludeMissing
        toolUseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("cache_control")
        @ExcludeMissing
        cacheControl: JsonField<BetaCacheControlEphemeral> = JsonMissing.of(),
        @JsonProperty("content") @ExcludeMissing content: JsonField<Content> = JsonMissing.of(),
        @JsonProperty("is_error") @ExcludeMissing isError: JsonField<Boolean> = JsonMissing.of(),
    ) : this(toolUseId, type, cacheControl, content, isError, mutableMapOf())

    /**
     * @throws AnthropicInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun toolUseId(): String = toolUseId.getRequired("tool_use_id")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("tool_result")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * @throws AnthropicInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cacheControl(): Optional<BetaCacheControlEphemeral> =
        Optional.ofNullable(cacheControl.getNullable("cache_control"))

    /**
     * @throws AnthropicInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun content(): Optional<Content> = Optional.ofNullable(content.getNullable("content"))

    /**
     * @throws AnthropicInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isError(): Optional<Boolean> = Optional.ofNullable(isError.getNullable("is_error"))

    /**
     * Returns the raw JSON value of [toolUseId].
     *
     * Unlike [toolUseId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_use_id") @ExcludeMissing fun _toolUseId(): JsonField<String> = toolUseId

    /**
     * Returns the raw JSON value of [cacheControl].
     *
     * Unlike [cacheControl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cache_control")
    @ExcludeMissing
    fun _cacheControl(): JsonField<BetaCacheControlEphemeral> = cacheControl

    /**
     * Returns the raw JSON value of [content].
     *
     * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

    /**
     * Returns the raw JSON value of [isError].
     *
     * Unlike [isError], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_error") @ExcludeMissing fun _isError(): JsonField<Boolean> = isError

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BetaToolResultBlockParam].
         *
         * The following fields are required:
         * ```java
         * .toolUseId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaToolResultBlockParam]. */
    class Builder internal constructor() {

        private var toolUseId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("tool_result")
        private var cacheControl: JsonField<BetaCacheControlEphemeral> = JsonMissing.of()
        private var content: JsonField<Content> = JsonMissing.of()
        private var isError: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaToolResultBlockParam: BetaToolResultBlockParam) = apply {
            toolUseId = betaToolResultBlockParam.toolUseId
            type = betaToolResultBlockParam.type
            cacheControl = betaToolResultBlockParam.cacheControl
            content = betaToolResultBlockParam.content
            isError = betaToolResultBlockParam.isError
            additionalProperties = betaToolResultBlockParam.additionalProperties.toMutableMap()
        }

        fun toolUseId(toolUseId: String) = toolUseId(JsonField.of(toolUseId))

        /**
         * Sets [Builder.toolUseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolUseId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun toolUseId(toolUseId: JsonField<String>) = apply { this.toolUseId = toolUseId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("tool_result")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun cacheControl(cacheControl: BetaCacheControlEphemeral?) =
            cacheControl(JsonField.ofNullable(cacheControl))

        /** Alias for calling [Builder.cacheControl] with `cacheControl.orElse(null)`. */
        fun cacheControl(cacheControl: Optional<BetaCacheControlEphemeral>) =
            cacheControl(cacheControl.getOrNull())

        /**
         * Sets [Builder.cacheControl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cacheControl] with a well-typed
         * [BetaCacheControlEphemeral] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun cacheControl(cacheControl: JsonField<BetaCacheControlEphemeral>) = apply {
            this.cacheControl = cacheControl
        }

        fun content(content: Content) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed [Content] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun content(content: JsonField<Content>) = apply { this.content = content }

        /** Alias for calling [content] with `Content.ofString(string)`. */
        fun content(string: String) = content(Content.ofString(string))

        /** Alias for calling [content] with `Content.ofBlocks(blocks)`. */
        fun contentOfBlocks(blocks: List<Content.Block>) = content(Content.ofBlocks(blocks))

        fun isError(isError: Boolean) = isError(JsonField.of(isError))

        /**
         * Sets [Builder.isError] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isError] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isError(isError: JsonField<Boolean>) = apply { this.isError = isError }

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

        /**
         * Returns an immutable instance of [BetaToolResultBlockParam].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .toolUseId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaToolResultBlockParam =
            BetaToolResultBlockParam(
                checkRequired("toolUseId", toolUseId),
                type,
                cacheControl,
                content,
                isError,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BetaToolResultBlockParam = apply {
        if (validated) {
            return@apply
        }

        toolUseId()
        _type().let {
            if (it != JsonValue.from("tool_result")) {
                throw AnthropicInvalidDataException("'type' is invalid, received $it")
            }
        }
        cacheControl().ifPresent { it.validate() }
        content().ifPresent { it.validate() }
        isError()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: AnthropicInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (toolUseId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("tool_result")) 1 else 0 } +
            (cacheControl.asKnown().getOrNull()?.validity() ?: 0) +
            (content.asKnown().getOrNull()?.validity() ?: 0) +
            (if (isError.asKnown().isPresent) 1 else 0)

    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val string: String? = null,
        private val blocks: List<Block>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun blocks(): Optional<List<Block>> = Optional.ofNullable(blocks)

        fun isString(): Boolean = string != null

        fun isBlocks(): Boolean = blocks != null

        fun asString(): String = string.getOrThrow("string")

        fun asBlocks(): List<Block> = blocks.getOrThrow("blocks")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                blocks != null -> visitor.visitBlocks(blocks)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Content = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitBlocks(blocks: List<Block>) {
                        blocks.forEach { it.validate() }
                    }
                }
            )
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: AnthropicInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitString(string: String) = 1

                    override fun visitBlocks(blocks: List<Block>) =
                        blocks.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Content && string == other.string && blocks == other.blocks /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, blocks) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Content{string=$string}"
                blocks != null -> "Content{blocks=$blocks}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Content(string = string)

            @JvmStatic fun ofBlocks(blocks: List<Block>) = Content(blocks = blocks)
        }

        /**
         * An interface that defines how to map each variant of [Content] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitBlocks(blocks: List<Block>): T

            /**
             * Maps an unknown variant of [Content] to a value of type [T].
             *
             * An instance of [Content] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws AnthropicInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw AnthropicInvalidDataException("Unknown Content: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Content>(Content::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Content {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Content(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<Block>>())?.let {
                                Content(blocks = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Content(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Content>(Content::class) {

            override fun serialize(
                value: Content,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.blocks != null -> generator.writeObject(value.blocks)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }

        @JsonDeserialize(using = Block.Deserializer::class)
        @JsonSerialize(using = Block.Serializer::class)
        class Block
        private constructor(
            private val betaTextBlockParam: BetaTextBlockParam? = null,
            private val betaImageBlockParam: BetaImageBlockParam? = null,
            private val _json: JsonValue? = null,
        ) {

            fun betaTextBlockParam(): Optional<BetaTextBlockParam> =
                Optional.ofNullable(betaTextBlockParam)

            fun betaImageBlockParam(): Optional<BetaImageBlockParam> =
                Optional.ofNullable(betaImageBlockParam)

            fun isBetaTextBlockParam(): Boolean = betaTextBlockParam != null

            fun isBetaImageBlockParam(): Boolean = betaImageBlockParam != null

            fun asBetaTextBlockParam(): BetaTextBlockParam =
                betaTextBlockParam.getOrThrow("betaTextBlockParam")

            fun asBetaImageBlockParam(): BetaImageBlockParam =
                betaImageBlockParam.getOrThrow("betaImageBlockParam")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    betaTextBlockParam != null ->
                        visitor.visitBetaTextBlockParam(betaTextBlockParam)
                    betaImageBlockParam != null ->
                        visitor.visitBetaImageBlockParam(betaImageBlockParam)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Block = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitBetaTextBlockParam(
                            betaTextBlockParam: BetaTextBlockParam
                        ) {
                            betaTextBlockParam.validate()
                        }

                        override fun visitBetaImageBlockParam(
                            betaImageBlockParam: BetaImageBlockParam
                        ) {
                            betaImageBlockParam.validate()
                        }
                    }
                )
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: AnthropicInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                accept(
                    object : Visitor<Int> {
                        override fun visitBetaTextBlockParam(
                            betaTextBlockParam: BetaTextBlockParam
                        ) = betaTextBlockParam.validity()

                        override fun visitBetaImageBlockParam(
                            betaImageBlockParam: BetaImageBlockParam
                        ) = betaImageBlockParam.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Block && betaTextBlockParam == other.betaTextBlockParam && betaImageBlockParam == other.betaImageBlockParam /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(betaTextBlockParam, betaImageBlockParam) /* spotless:on */

            override fun toString(): String =
                when {
                    betaTextBlockParam != null -> "Block{betaTextBlockParam=$betaTextBlockParam}"
                    betaImageBlockParam != null -> "Block{betaImageBlockParam=$betaImageBlockParam}"
                    _json != null -> "Block{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Block")
                }

            companion object {

                @JvmStatic
                fun ofBetaTextBlockParam(betaTextBlockParam: BetaTextBlockParam) =
                    Block(betaTextBlockParam = betaTextBlockParam)

                @JvmStatic
                fun ofBetaImageBlockParam(betaImageBlockParam: BetaImageBlockParam) =
                    Block(betaImageBlockParam = betaImageBlockParam)
            }

            /**
             * An interface that defines how to map each variant of [Block] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitBetaTextBlockParam(betaTextBlockParam: BetaTextBlockParam): T

                fun visitBetaImageBlockParam(betaImageBlockParam: BetaImageBlockParam): T

                /**
                 * Maps an unknown variant of [Block] to a value of type [T].
                 *
                 * An instance of [Block] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws AnthropicInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw AnthropicInvalidDataException("Unknown Block: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Block>(Block::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Block {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "text" -> {
                            return tryDeserialize(node, jacksonTypeRef<BetaTextBlockParam>())?.let {
                                Block(betaTextBlockParam = it, _json = json)
                            } ?: Block(_json = json)
                        }
                        "image" -> {
                            return tryDeserialize(node, jacksonTypeRef<BetaImageBlockParam>())
                                ?.let { Block(betaImageBlockParam = it, _json = json) }
                                ?: Block(_json = json)
                        }
                    }

                    return Block(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Block>(Block::class) {

                override fun serialize(
                    value: Block,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.betaTextBlockParam != null ->
                            generator.writeObject(value.betaTextBlockParam)
                        value.betaImageBlockParam != null ->
                            generator.writeObject(value.betaImageBlockParam)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Block")
                    }
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaToolResultBlockParam && toolUseId == other.toolUseId && type == other.type && cacheControl == other.cacheControl && content == other.content && isError == other.isError && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(toolUseId, type, cacheControl, content, isError, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaToolResultBlockParam{toolUseId=$toolUseId, type=$type, cacheControl=$cacheControl, content=$content, isError=$isError, additionalProperties=$additionalProperties}"
}
