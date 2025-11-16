package com.example.newsfeed.presenter.component

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NewsCard(
    state: NewsCardState,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            GlideImage(
                model = // "https://i.abcnewsfe.com/a/a0260dbd-b305-4e6f-bc02-aa9fa96a48ab/wirestory_5061f62a504297b6c384ee513ac47928_16x9.jpg?w=1600"
                    state.imageUrl,
                contentDescription = "newImage",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp) // grid-friendly size
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                loading = placeholder(R.drawable.screen_background_dark),
                failure = placeholder(R.drawable.screen_background_dark),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = state.title,
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = state.description,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {
    NewsCard(
        state = NewsCardState(
            title = "Breaking News: Compose UI is Awesome!",
            description = "Jetpack Compose makes UI development faster, easier, and more intuitive. Here's how developers worldwide are adopting it.",
            imageUrl = "https://picsum.photos/200",
            articleUrl = ""
        )
    )
}

