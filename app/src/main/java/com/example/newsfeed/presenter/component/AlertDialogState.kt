package com.example.newsfeed.presenter.component

data class AlertDialogState(
    val title: String = "",
    val description: String = "",
    val positiveButton: String? = null,
    val negativeButton: String? = null
)
