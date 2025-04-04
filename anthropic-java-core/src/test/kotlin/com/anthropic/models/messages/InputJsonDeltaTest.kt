// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputJsonDeltaTest {

    @Test
    fun create() {
        val inputJsonDelta = InputJsonDelta.builder().partialJson("partial_json").build()

        assertThat(inputJsonDelta.partialJson()).isEqualTo("partial_json")
    }
}
