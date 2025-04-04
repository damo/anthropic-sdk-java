// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UrlImageSourceTest {

    @Test
    fun create() {
        val urlImageSource = UrlImageSource.builder().url("url").build()

        assertThat(urlImageSource.url()).isEqualTo("url")
    }
}
