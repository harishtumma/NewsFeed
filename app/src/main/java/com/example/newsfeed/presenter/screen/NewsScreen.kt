package com.example.newsfeed.presenter.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newsfeed.presenter.component.NewsCard
import com.example.newsfeed.presenter.component.NewsCardState
import com.example.newsfeed.presenter.component.showAlert
import com.example.newsfeed.presenter.theme.NewsFeedTheme
import com.example.newsfeed.presenter.viewmodel.NewsFeedViewModel


@Composable
fun NewsScreen(onItemClick: (NewsCardState) -> Unit={}) {
    val viewModel: NewsFeedViewModel = hiltViewModel()
    val newsScreenState = viewModel.newsScreenState.collectAsStateWithLifecycle()
    NewsScreenComponent(newsScreenState = newsScreenState.value, onItemClick =onItemClick) {
        viewModel.resetAlertState()
    }
    LaunchedEffect(Unit) {
        viewModel.loadHeadlines()
    }
}

@Composable
fun NewsScreenComponent(newsScreenState: NewsScreenState,onItemClick: (NewsCardState) -> Unit = {}, onPrimaryAlertClicked: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        if (newsScreenState.isLoading) {
            CircularProgressIndicator()
        } else if (newsScreenState.alertDialogState != null) {
            showAlert(
                alertDialogState = newsScreenState.alertDialogState!!,
                onPrimary = {
                    onPrimaryAlertClicked()
                }, onDismiss = {

                }
            )
        } else {
            NewsContent(newsScreenState.news,onItemClick)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsContent(items: List<NewsCardState>,onItemClick: (NewsCardState) -> Unit = {}) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items.size) { index ->
            NewsCard(
                state = items[index],
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(items[index])
                    }
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 500)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsContentPreview() {
    val newsList = List(10) {
        NewsCardState(
            title = "Test news title",
            description = "description.\n description",
            imageUrl = "https://test/200",
            articleUrl = ""
        )
    }

    NewsFeedTheme {
        NewsContent(newsList)
    }
}




