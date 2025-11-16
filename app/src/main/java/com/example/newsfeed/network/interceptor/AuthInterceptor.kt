package com.example.newsfeed.network.interceptor

import com.example.newsfeed.network.ApiKeyProvider
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    private val apiKeyProvider: ApiKeyProvider
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = apiKeyProvider.getApiKey()
        val request = chain.request().newBuilder()
            .build()
        return chain.proceed(request)
    }
}
