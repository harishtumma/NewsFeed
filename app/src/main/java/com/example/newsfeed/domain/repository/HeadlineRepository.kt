package com.example.newsfeed.domain.repository

import com.example.newsfeed.domain.data.HeadlineData

interface HeadlineRepository {
    suspend fun getHeadlines(): List<HeadlineData>
}