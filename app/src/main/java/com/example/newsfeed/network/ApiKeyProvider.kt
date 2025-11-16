package com.example.newsfeed.network

interface ApiKeyProvider {
    fun getApiKey():String
}