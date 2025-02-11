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

@NoAutoDetect
class BetaErrorResponse
@JsonCreator
private constructor(
    @JsonProperty("error")
    @ExcludeMissing
    private val error: JsonField<BetaError> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun error(): BetaError = error.getRequired("error")

    fun type(): Type = type.getRequired("type")

    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<BetaError> = error

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): BetaErrorResponse = apply {
        if (validated) {
            return@apply
        }

        error().validate()
        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaErrorResponse]. */
    class Builder internal constructor() {

        private var error: JsonField<BetaError>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaErrorResponse: BetaErrorResponse) = apply {
            error = betaErrorResponse.error
            type = betaErrorResponse.type
            additionalProperties = betaErrorResponse.additionalProperties.toMutableMap()
        }

        fun error(error: BetaError) = error(JsonField.of(error))

        fun error(error: JsonField<BetaError>) = apply { this.error = error }

        fun error(invalidRequest: BetaInvalidRequestError) =
            error(BetaError.ofInvalidRequest(invalidRequest))

        fun invalidRequestError(message: String) =
            error(
                BetaInvalidRequestError.builder()
                    .type(BetaInvalidRequestError.Type.INVALID_REQUEST_ERROR)
                    .message(message)
                    .build()
            )

        fun error(authentication: BetaAuthenticationError) =
            error(BetaError.ofAuthentication(authentication))

        fun authenticationError(message: String) =
            error(
                BetaAuthenticationError.builder()
                    .type(BetaAuthenticationError.Type.AUTHENTICATION_ERROR)
                    .message(message)
                    .build()
            )

        fun error(billing: BetaBillingError) = error(BetaError.ofBilling(billing))

        fun billingError(message: String) =
            error(
                BetaBillingError.builder()
                    .type(BetaBillingError.Type.BILLING_ERROR)
                    .message(message)
                    .build()
            )

        fun error(permission: BetaPermissionError) = error(BetaError.ofPermission(permission))

        fun permissionError(message: String) =
            error(
                BetaPermissionError.builder()
                    .type(BetaPermissionError.Type.PERMISSION_ERROR)
                    .message(message)
                    .build()
            )

        fun error(notFound: BetaNotFoundError) = error(BetaError.ofNotFound(notFound))

        fun notFoundError(message: String) =
            error(
                BetaNotFoundError.builder()
                    .type(BetaNotFoundError.Type.NOT_FOUND_ERROR)
                    .message(message)
                    .build()
            )

        fun error(rateLimit: BetaRateLimitError) = error(BetaError.ofRateLimit(rateLimit))

        fun rateLimitError(message: String) =
            error(
                BetaRateLimitError.builder()
                    .type(BetaRateLimitError.Type.RATE_LIMIT_ERROR)
                    .message(message)
                    .build()
            )

        fun error(gatewayTimeout: BetaGatewayTimeoutError) =
            error(BetaError.ofGatewayTimeout(gatewayTimeout))

        fun gatewayTimeoutError(message: String) =
            error(
                BetaGatewayTimeoutError.builder()
                    .type(BetaGatewayTimeoutError.Type.TIMEOUT_ERROR)
                    .message(message)
                    .build()
            )

        fun error(api: BetaApiError) = error(BetaError.ofApi(api))

        fun apiError(message: String) =
            error(BetaApiError.builder().type(BetaApiError.Type.API_ERROR).message(message).build())

        fun error(overloaded: BetaOverloadedError) = error(BetaError.ofOverloaded(overloaded))

        fun overloadedError(message: String) =
            error(
                BetaOverloadedError.builder()
                    .type(BetaOverloadedError.Type.OVERLOADED_ERROR)
                    .message(message)
                    .build()
            )

        fun type(type: Type) = type(JsonField.of(type))

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

        fun build(): BetaErrorResponse =
            BetaErrorResponse(
                checkRequired("error", error),
                checkRequired("type", type),
                additionalProperties.toImmutable(),
            )
    }

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

            @JvmField val ERROR = of("error")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            ERROR,
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
            ERROR,
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
                ERROR -> Value.ERROR
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
                ERROR -> Known.ERROR
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

        return /* spotless:off */ other is BetaErrorResponse && error == other.error && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(error, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaErrorResponse{error=$error, type=$type, additionalProperties=$additionalProperties}"
}
