// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import com.anthropic.core.BaseDeserializer
import com.anthropic.core.BaseSerializer
import com.anthropic.core.JsonValue
import com.anthropic.core.getOrThrow
import com.anthropic.errors.AnthropicInvalidDataException
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = ContentBlockSourceContent.Deserializer::class)
@JsonSerialize(using = ContentBlockSourceContent.Serializer::class)
class ContentBlockSourceContent
private constructor(
    private val textBlockParam: TextBlockParam? = null,
    private val imageBlockParam: ImageBlockParam? = null,
    private val _json: JsonValue? = null,
) {

    fun textBlockParam(): Optional<TextBlockParam> = Optional.ofNullable(textBlockParam)

    fun imageBlockParam(): Optional<ImageBlockParam> = Optional.ofNullable(imageBlockParam)

    fun isTextBlockParam(): Boolean = textBlockParam != null

    fun isImageBlockParam(): Boolean = imageBlockParam != null

    fun asTextBlockParam(): TextBlockParam = textBlockParam.getOrThrow("textBlockParam")

    fun asImageBlockParam(): ImageBlockParam = imageBlockParam.getOrThrow("imageBlockParam")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            textBlockParam != null -> visitor.visitTextBlockParam(textBlockParam)
            imageBlockParam != null -> visitor.visitImageBlockParam(imageBlockParam)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ContentBlockSourceContent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitTextBlockParam(textBlockParam: TextBlockParam) {
                    textBlockParam.validate()
                }

                override fun visitImageBlockParam(imageBlockParam: ImageBlockParam) {
                    imageBlockParam.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitTextBlockParam(textBlockParam: TextBlockParam) =
                    textBlockParam.validity()

                override fun visitImageBlockParam(imageBlockParam: ImageBlockParam) =
                    imageBlockParam.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ContentBlockSourceContent && textBlockParam == other.textBlockParam && imageBlockParam == other.imageBlockParam /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(textBlockParam, imageBlockParam) /* spotless:on */

    override fun toString(): String =
        when {
            textBlockParam != null -> "ContentBlockSourceContent{textBlockParam=$textBlockParam}"
            imageBlockParam != null -> "ContentBlockSourceContent{imageBlockParam=$imageBlockParam}"
            _json != null -> "ContentBlockSourceContent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ContentBlockSourceContent")
        }

    companion object {

        @JvmStatic
        fun ofTextBlockParam(textBlockParam: TextBlockParam) =
            ContentBlockSourceContent(textBlockParam = textBlockParam)

        @JvmStatic
        fun ofImageBlockParam(imageBlockParam: ImageBlockParam) =
            ContentBlockSourceContent(imageBlockParam = imageBlockParam)
    }

    /**
     * An interface that defines how to map each variant of [ContentBlockSourceContent] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        fun visitTextBlockParam(textBlockParam: TextBlockParam): T

        fun visitImageBlockParam(imageBlockParam: ImageBlockParam): T

        /**
         * Maps an unknown variant of [ContentBlockSourceContent] to a value of type [T].
         *
         * An instance of [ContentBlockSourceContent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws AnthropicInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw AnthropicInvalidDataException("Unknown ContentBlockSourceContent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ContentBlockSourceContent>(ContentBlockSourceContent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ContentBlockSourceContent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "text" -> {
                    return tryDeserialize(node, jacksonTypeRef<TextBlockParam>())?.let {
                        ContentBlockSourceContent(textBlockParam = it, _json = json)
                    } ?: ContentBlockSourceContent(_json = json)
                }
                "image" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImageBlockParam>())?.let {
                        ContentBlockSourceContent(imageBlockParam = it, _json = json)
                    } ?: ContentBlockSourceContent(_json = json)
                }
            }

            return ContentBlockSourceContent(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ContentBlockSourceContent>(ContentBlockSourceContent::class) {

        override fun serialize(
            value: ContentBlockSourceContent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.textBlockParam != null -> generator.writeObject(value.textBlockParam)
                value.imageBlockParam != null -> generator.writeObject(value.imageBlockParam)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ContentBlockSourceContent")
            }
        }
    }
}
