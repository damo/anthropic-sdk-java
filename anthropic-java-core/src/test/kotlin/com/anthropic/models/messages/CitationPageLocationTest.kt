// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CitationPageLocationTest {

    @Test
    fun create() {
        val citationPageLocation =
            CitationPageLocation.builder()
                .citedText("cited_text")
                .documentIndex(0L)
                .documentTitle("document_title")
                .endPageNumber(0L)
                .startPageNumber(1L)
                .build()

        assertThat(citationPageLocation.citedText()).isEqualTo("cited_text")
        assertThat(citationPageLocation.documentIndex()).isEqualTo(0L)
        assertThat(citationPageLocation.documentTitle()).contains("document_title")
        assertThat(citationPageLocation.endPageNumber()).isEqualTo(0L)
        assertThat(citationPageLocation.startPageNumber()).isEqualTo(1L)
    }
}
