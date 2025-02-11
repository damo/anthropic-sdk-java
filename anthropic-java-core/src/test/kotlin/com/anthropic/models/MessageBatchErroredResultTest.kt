// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchErroredResultTest {

    @Test
    fun createMessageBatchErroredResult() {
        val messageBatchErroredResult =
            MessageBatchErroredResult.builder()
                .error(
                    ErrorResponse.builder()
                        .invalidRequestErrorError("message")
                        .type(ErrorResponse.Type.ERROR)
                        .build()
                )
                .type(MessageBatchErroredResult.Type.ERRORED)
                .build()
        assertThat(messageBatchErroredResult).isNotNull
        assertThat(messageBatchErroredResult.error())
            .isEqualTo(
                ErrorResponse.builder()
                    .invalidRequestErrorError("message")
                    .type(ErrorResponse.Type.ERROR)
                    .build()
            )
        assertThat(messageBatchErroredResult.type())
            .isEqualTo(MessageBatchErroredResult.Type.ERRORED)
    }
}
