package com.example.newsfeed.di

import com.example.newsfeed.data.repository.HeadlineRepositoryImpl
import com.example.newsfeed.data.utils.ApiKeyProviderImpl
import com.example.newsfeed.domain.repository.HeadlineRepository
import com.example.newsfeed.network.ApiKeyProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindHeadlineRepository(headlineRepository: HeadlineRepositoryImpl): HeadlineRepository

    @Binds
    abstract fun bindApiKeyProvider(apiKeyProvider: ApiKeyProviderImpl): ApiKeyProvider

}