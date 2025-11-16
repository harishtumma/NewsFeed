package com.example.newsfeed.data.mapper

import com.example.newsfeed.network.dao.headlindao.ArticlesItem
import com.example.newsfeed.network.dao.headlindao.Source
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class ToHeadlinesTest {
    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun `ArticlesItem toHeadlines maps successfully`() {
        val source =mockk<Source>()
         val article = ArticlesItem(
              title = "Test Title",
              description = "Test Description",
              urlToImage = "https://example.com/image.jpg",
              url = "https://example.com/article",
             source = source
          )

        val result = article.toHeadlines()

        assertEquals("Test Title", result.headline)
        assertEquals("Test Description", result.description)
        assertEquals("https://example.com/image.jpg", result.imageUrl)
        assertEquals("https://example.com/article", result.url)
    }

}