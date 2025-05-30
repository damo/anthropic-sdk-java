// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import com.anthropic.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Base64ImageSourceTest {

    @Test
    fun create() {
        val base64ImageSource =
            Base64ImageSource.builder()
                .data("U3RhaW5sZXNzIHJvY2tz")
                .mediaType(Base64ImageSource.MediaType.IMAGE_JPEG)
                .build()

        assertThat(base64ImageSource.data()).isEqualTo("U3RhaW5sZXNzIHJvY2tz")
        assertThat(base64ImageSource.mediaType()).isEqualTo(Base64ImageSource.MediaType.IMAGE_JPEG)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val base64ImageSource =
            Base64ImageSource.builder()
                .data("U3RhaW5sZXNzIHJvY2tz")
                .mediaType(Base64ImageSource.MediaType.IMAGE_JPEG)
                .build()

        val roundtrippedBase64ImageSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(base64ImageSource),
                jacksonTypeRef<Base64ImageSource>(),
            )

        assertThat(roundtrippedBase64ImageSource).isEqualTo(base64ImageSource)
    }
}
