// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.completions

import com.anthropic.models.messages.Model
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompletionTest {

    @Test
    fun create() {
        val completion =
            Completion.builder()
                .id("compl_018CKm6gsux7P8yMcwZbeCPw")
                .completion(" Hello! My name is Claude.")
                .model(Model.CLAUDE_3_7_SONNET_LATEST)
                .stopReason("stop_sequence")
                .build()

        assertThat(completion.id()).isEqualTo("compl_018CKm6gsux7P8yMcwZbeCPw")
        assertThat(completion.completion()).isEqualTo(" Hello! My name is Claude.")
        assertThat(completion.model()).isEqualTo(Model.CLAUDE_3_7_SONNET_LATEST)
        assertThat(completion.stopReason()).contains("stop_sequence")
    }
}
