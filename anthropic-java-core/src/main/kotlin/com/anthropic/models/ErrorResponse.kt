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
class ErrorResponse
@JsonCreator
private constructor(
    @JsonProperty("error")
    @ExcludeMissing
    private val error: JsonField<ErrorObject> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun error(): ErrorObject = error.getRequired("error")

    fun type(): Type = type.getRequired("type")

    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<ErrorObject> = error

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ErrorResponse = apply {
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

    /** A builder for [ErrorResponse]. */
    class Builder internal constructor() {

        private var error: JsonField<ErrorObject>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(errorResponse: ErrorResponse) = apply {
            error = errorResponse.error
            type = errorResponse.type
            additionalProperties = errorResponse.additionalProperties.toMutableMap()
        }

        fun error(error: ErrorObject) = error(JsonField.of(error))

        fun error(error: JsonField<ErrorObject>) = apply { this.error = error }

        fun error(invalidRequestError: InvalidRequestError) =
            error(ErrorObject.ofInvalidRequestError(invalidRequestError))

        fun invalidRequestErrorError(message: String) =
            error(
                InvalidRequestError.builder()
                    .type(InvalidRequestError.Type.INVALID_REQUEST_ERROR)
                    .message(message)
                    .build()
            )

        fun error(authenticationError: AuthenticationError) =
            error(ErrorObject.ofAuthenticationError(authenticationError))

        fun authenticationErrorError(message: String) =
            error(
                AuthenticationError.builder()
                    .type(AuthenticationError.Type.AUTHENTICATION_ERROR)
                    .message(message)
                    .build()
            )

        fun error(billingError: BillingError) = error(ErrorObject.ofBillingError(billingError))

        fun billingErrorError(message: String) =
            error(
                BillingError.builder()
                    .type(BillingError.Type.BILLING_ERROR)
                    .message(message)
                    .build()
            )

        fun error(permissionError: PermissionError) =
            error(ErrorObject.ofPermissionError(permissionError))

        fun permissionErrorError(message: String) =
            error(
                PermissionError.builder()
                    .type(PermissionError.Type.PERMISSION_ERROR)
                    .message(message)
                    .build()
            )

        fun error(notFoundError: NotFoundError) = error(ErrorObject.ofNotFoundError(notFoundError))

        fun notFoundErrorError(message: String) =
            error(
                NotFoundError.builder()
                    .type(NotFoundError.Type.NOT_FOUND_ERROR)
                    .message(message)
                    .build()
            )

        fun error(rateLimitError: RateLimitError) =
            error(ErrorObject.ofRateLimitError(rateLimitError))

        fun rateLimitErrorError(message: String) =
            error(
                RateLimitError.builder()
                    .type(RateLimitError.Type.RATE_LIMIT_ERROR)
                    .message(message)
                    .build()
            )

        fun error(gatewayTimeoutError: GatewayTimeoutError) =
            error(ErrorObject.ofGatewayTimeoutError(gatewayTimeoutError))

        fun gatewayTimeoutErrorError(message: String) =
            error(
                GatewayTimeoutError.builder()
                    .type(GatewayTimeoutError.Type.TIMEOUT_ERROR)
                    .message(message)
                    .build()
            )

        fun error(api: ApiErrorObject) = error(ErrorObject.ofApi(api))

        fun apiError(message: String) =
            error(
                ApiErrorObject.builder()
                    .type(ApiErrorObject.Type.API_ERROR)
                    .message(message)
                    .build()
            )

        fun error(overloadedError: OverloadedError) =
            error(ErrorObject.ofOverloadedError(overloadedError))

        fun overloadedErrorError(message: String) =
            error(
                OverloadedError.builder()
                    .type(OverloadedError.Type.OVERLOADED_ERROR)
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

        fun build(): ErrorResponse =
            ErrorResponse(
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

        return /* spotless:off */ other is ErrorResponse && error == other.error && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(error, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ErrorResponse{error=$error, type=$type, additionalProperties=$additionalProperties}"
}
