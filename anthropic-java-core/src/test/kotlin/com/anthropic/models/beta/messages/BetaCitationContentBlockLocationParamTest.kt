// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.beta.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaCitationContentBlockLocationParamTest {

    @Test
    fun create() {
        val betaCitationContentBlockLocationParam =
            BetaCitationContentBlockLocationParam.builder()
                .citedText("cited_text")
                .documentIndex(0L)
                .documentTitle("x")
                .endBlockIndex(0L)
                .startBlockIndex(0L)
                .build()

        assertThat(betaCitationContentBlockLocationParam.citedText()).isEqualTo("cited_text")
        assertThat(betaCitationContentBlockLocationParam.documentIndex()).isEqualTo(0L)
        assertThat(betaCitationContentBlockLocationParam.documentTitle()).contains("x")
        assertThat(betaCitationContentBlockLocationParam.endBlockIndex()).isEqualTo(0L)
        assertThat(betaCitationContentBlockLocationParam.startBlockIndex()).isEqualTo(0L)
    }
}
