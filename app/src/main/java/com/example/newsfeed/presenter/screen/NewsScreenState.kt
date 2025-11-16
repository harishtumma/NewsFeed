package com.example.newsfeed.presenter.screen

import androidx.compose.runtime.Immutable
import com.example.newsfeed.presenter.component.AlertDialogState
import com.example.newsfeed.presenter.component.NewsCardState

@Immutable
data class NewsScreenState(
    val isLoading: Boolean = false,
    val news: List<NewsCardState> = emptyList(),
    val error: String? = null,
    val alertDialogState: AlertDialogState?=null
)
