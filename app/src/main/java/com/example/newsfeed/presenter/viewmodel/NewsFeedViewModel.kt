package com.example.newsfeed.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsfeed.domain.data.HeadlineData
import com.example.newsfeed.domain.uscase.HeadlineListUseCase
import com.example.newsfeed.presenter.component.AlertDialogState
import com.example.newsfeed.presenter.component.NewsCardState
import com.example.newsfeed.presenter.screen.NewsScreenState
import com.example.newsfeed.presenter.toNewsCardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsFeedViewModel @Inject constructor(val headlineListUseCase: HeadlineListUseCase) :
    ViewModel() {
    private val _newsScreenState = MutableStateFlow(NewsScreenState())
    val newsScreenState = _newsScreenState.asStateFlow()


    fun resetAlertState() {
        _newsScreenState.update {
            it.copy(alertDialogState = null)
        }
    }


    fun loadHeadlines() {
        viewModelScope.launch {
            headlineListUseCase().collect { headlineData ->
                when (headlineData) {
                    is Resource.Error -> {
                        _newsScreenState.update {
                            val alert = AlertDialogState("Error ", headlineData.error.message, "Ok")
                            it.copy(
                                error = headlineData.error.message,
                                isLoading = false,
                                alertDialogState = alert
                            )
                        }

                    }

                    Resource.Loading -> {
                        _newsScreenState.update {
                            it.copy(error = null, isLoading = true)
                        }
                    }

                    is Resource.Success<*> -> {
                        val list = (headlineData.data as List<HeadlineData>).map { it ->
                            it.toNewsCardState()
                        }
                        _newsScreenState.update {
                            it.copy(news = list, error = null, isLoading = false)
                        }
                    }
                }

            }
        }
    }
}