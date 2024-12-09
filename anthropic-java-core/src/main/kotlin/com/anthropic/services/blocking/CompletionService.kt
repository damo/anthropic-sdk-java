// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.anthropic.services.blocking

import com.anthropic.core.RequestOptions
import com.anthropic.core.http.StreamResponse
import com.anthropic.models.Completion
import com.anthropic.models.CompletionCreateParams
import com.google.errorprone.annotations.MustBeClosed

interface CompletionService {

    /**
     * [Legacy] Create a Text Completion.
     *
     * The Text Completions API is a legacy API. We recommend using the
     * [Messages API](https://docs.anthropic.com/en/api/messages) going forward.
     *
     * Future models and features will not be compatible with Text Completions. See our
     * [migration guide](https://docs.anthropic.com/en/api/migrating-from-text-completions-to-messages)
     * for guidance in migrating from Text Completions to Messages.
     */
    @JvmOverloads
    fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Completion

    /**
     * [Legacy] Create a Text Completion.
     *
     * The Text Completions API is a legacy API. We recommend using the
     * [Messages API](https://docs.anthropic.com/en/api/messages) going forward.
     *
     * Future models and features will not be compatible with Text Completions. See our
     * [migration guide](https://docs.anthropic.com/en/api/migrating-from-text-completions-to-messages)
     * for guidance in migrating from Text Completions to Messages.
     */
    @JvmOverloads
    @MustBeClosed
    fun createStreaming(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): StreamResponse<Completion>
}
