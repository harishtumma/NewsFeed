package com.example.haat.network.di

import com.example.newsfeed.network.apiservices.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    val BASE_URL ="https://newsapi.org"
     @Provides
    fun retrofitBuilderProvider(okHttpClient: OkHttpClient): Retrofit.Builder{
       var res= Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .client(okHttpClient)
        return res
    }

    @Provides
    fun okhttpProvider(): OkHttpClient
    {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Provides
    fun providesRetrofit(builder:Retrofit.Builder): Retrofit
    {
        return builder.build()
    }

    @Provides
    fun getNetworkService(retrofit: Retrofit)=retrofit.create(NewsService::class.java)

}