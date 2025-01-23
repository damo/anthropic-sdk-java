// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaTextBlockTest {

    @Test
    fun createBetaTextBlock() {
        val betaTextBlock =
            BetaTextBlock.builder()
                .addCitation(
                    BetaCitationCharLocation.builder()
                        .citedText("cited_text")
                        .documentIndex(0L)
                        .documentTitle("document_title")
                        .endCharIndex(0L)
                        .startCharIndex(0L)
                        .type(BetaCitationCharLocation.Type.CHAR_LOCATION)
                        .build()
                )
                .text("text")
                .type(BetaTextBlock.Type.TEXT)
                .build()
        assertThat(betaTextBlock).isNotNull
        assertThat(betaTextBlock.citations().get())
            .containsExactly(
                BetaTextCitation.ofBetaCitationCharLocation(
                    BetaCitationCharLocation.builder()
                        .citedText("cited_text")
                        .documentIndex(0L)
                        .documentTitle("document_title")
                        .endCharIndex(0L)
                        .startCharIndex(0L)
                        .type(BetaCitationCharLocation.Type.CHAR_LOCATION)
                        .build()
                )
            )
        assertThat(betaTextBlock.text()).isEqualTo("text")
        assertThat(betaTextBlock.type()).isEqualTo(BetaTextBlock.Type.TEXT)
    }
}
