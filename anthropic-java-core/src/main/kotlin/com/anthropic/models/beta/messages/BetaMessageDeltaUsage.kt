// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.beta.messages

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

@NoAutoDetect
class BetaMessageDeltaUsage
@JsonCreator
private constructor(
    @JsonProperty("output_tokens")
    @ExcludeMissing
    private val outputTokens: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The cumulative number of output tokens which were used.
     *
     * @throws AnthropicInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

    /**
     * Returns the raw JSON value of [outputTokens].
     *
     * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_tokens")
    @ExcludeMissing
    fun _outputTokens(): JsonField<Long> = outputTokens

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): BetaMessageDeltaUsage = apply {
        if (validated) {
            return@apply
        }

        outputTokens()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BetaMessageDeltaUsage].
         *
         * The following fields are required:
         * ```java
         * .outputTokens()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaMessageDeltaUsage]. */
    class Builder internal constructor() {

        private var outputTokens: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaMessageDeltaUsage: BetaMessageDeltaUsage) = apply {
            outputTokens = betaMessageDeltaUsage.outputTokens
            additionalProperties = betaMessageDeltaUsage.additionalProperties.toMutableMap()
        }

        /** The cumulative number of output tokens which were used. */
        fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

        /**
         * Sets [Builder.outputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputTokens(outputTokens: JsonField<Long>) = apply { this.outputTokens = outputTokens }

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
         * Returns an immutable instance of [BetaMessageDeltaUsage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .outputTokens()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaMessageDeltaUsage =
            BetaMessageDeltaUsage(
                checkRequired("outputTokens", outputTokens),
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaMessageDeltaUsage && outputTokens == other.outputTokens && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(outputTokens, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaMessageDeltaUsage{outputTokens=$outputTokens, additionalProperties=$additionalProperties}"
}
