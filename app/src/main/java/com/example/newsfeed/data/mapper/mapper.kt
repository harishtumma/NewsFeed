package com.example.newsfeed.data.mapper

import com.example.newsfeed.domain.data.HeadlineData
import com.example.newsfeed.network.dao.headlindao.ArticlesItem
import com.example.newsfeed.network.dao.headlindao.HeadlinesDAO


fun ArticlesItem.toHeadlines(): HeadlineData {
    return HeadlineData(
        headline = this.title,
        description = this.description?:"",
        imageUrl = this.urlToImage?:"",
        url = this.url?:""
    )
}

fun HeadlinesDAO.toListOFHeadlines(): List<HeadlineData>?
{
    return this.articles?.map {
        it.toHeadlines()
    }
}
