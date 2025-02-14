package com.shifthackz.aisdv1.network.interceptor

import com.shifthackz.aisdv1.core.common.extensions.withoutUrlProtocol
import com.shifthackz.aisdv1.core.common.log.debugLog
import com.shifthackz.aisdv1.network.qualifiers.ApiUrlProvider
import okhttp3.logging.HttpLoggingInterceptor

internal class LoggingInterceptor(
    private val apiUrlProvider: ApiUrlProvider,
) {

    fun get() = HttpLoggingInterceptor { message ->
        val badPredicate = message.contains(
            apiUrlProvider.stableDiffusionCloudAiApiUrl.withoutUrlProtocol()
        )
        if (!badPredicate) debugLog(HTTP_TAG, message)
    }.apply {
//        level = HttpLoggingInterceptor.Level.BODY
        level = HttpLoggingInterceptor.Level.HEADERS
    }

    companion object {
        private const val HTTP_TAG = "HTTP"
    }
}
