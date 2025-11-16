package com.example.newsfeed.network.dao.headlindao

import com.google.gson.annotations.SerializedName

data class HeadlinesDAO(@SerializedName("totalResults")
                        val totalResults: Int = 0,
                        @SerializedName("articles")
                        val articles: List<ArticlesItem>?,
                        @SerializedName("status")
                        val status: String = "")