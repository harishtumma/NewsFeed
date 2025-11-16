package com.example.newsfeed.presenter

import com.example.newsfeed.domain.data.HeadlineData
import com.example.newsfeed.presenter.component.NewsCardState

fun HeadlineData.toNewsCardState()=
    NewsCardState(
        title = this.headline,
        description = this.description,
        imageUrl = this.imageUrl,
        articleUrl = this.url
    )

