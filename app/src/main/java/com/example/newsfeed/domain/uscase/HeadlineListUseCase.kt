package com.example.newsfeed.domain.uscase

import com.example.newsfeed.domain.data.ErrorData
import com.example.newsfeed.domain.repository.HeadlineRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HeadlineListUseCase @Inject constructor(val headlineRepository: HeadlineRepository) {
    operator fun invoke() = flow {
        emit(Resource.Loading)
        val headlines = headlineRepository.getHeadlines()
        emit(Resource.Success(headlines))
    }.catch { e ->
        emit(Resource.Error(ErrorData(e.message.toString())))
    }
}