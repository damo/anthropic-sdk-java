// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CitationContentBlockLocationParamTest {

    @Test
    fun create() {
        val citationContentBlockLocationParam =
            CitationContentBlockLocationParam.builder()
                .citedText("cited_text")
                .documentIndex(0L)
                .documentTitle("x")
                .endBlockIndex(0L)
                .startBlockIndex(0L)
                .build()

        assertThat(citationContentBlockLocationParam.citedText()).isEqualTo("cited_text")
        assertThat(citationContentBlockLocationParam.documentIndex()).isEqualTo(0L)
        assertThat(citationContentBlockLocationParam.documentTitle()).contains("x")
        assertThat(citationContentBlockLocationParam.endBlockIndex()).isEqualTo(0L)
        assertThat(citationContentBlockLocationParam.startBlockIndex()).isEqualTo(0L)
    }
}
