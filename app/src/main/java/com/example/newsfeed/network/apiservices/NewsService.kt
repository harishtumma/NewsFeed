package com.example.newsfeed.network.apiservices

import com.example.newsfeed.network.dao.headlindao.HeadlinesDAO
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String
    ): HeadlinesDAO
}