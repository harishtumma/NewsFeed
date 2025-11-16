package com.example.newsfeed.data.repository

import com.example.newsfeed.data.mapper.toListOFHeadlines
import com.example.newsfeed.domain.data.HeadlineData
import com.example.newsfeed.domain.repository.HeadlineRepository
import com.example.newsfeed.network.ApiKeyProvider
import com.example.newsfeed.network.apiservices.NewsService
import javax.inject.Inject

class HeadlineRepositoryImpl @Inject constructor(val newsService: NewsService, val apiKeyProvider: ApiKeyProvider): HeadlineRepository {
    override suspend fun getHeadlines(): List<HeadlineData> {
       return newsService.getTopHeadlines(apiKey=apiKeyProvider.getApiKey()).toListOFHeadlines()?: emptyList()
    }
}