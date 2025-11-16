package com.example.newsfeed.data.utils

import com.example.newsfeed.network.ApiKeyProvider
import javax.inject.Inject

class ApiKeyProviderImpl @Inject constructor():ApiKeyProvider {
    override fun getApiKey(): String {
        //todo this api key should be saved in cmak or  take it from server on splash screen and stores in encrypted share pref
        return "6f0d7c8fd5e84e2883f3dd25a600b37a"
    }
}