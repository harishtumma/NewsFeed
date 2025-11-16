package com.example.newsfeed.presenter.navigation

import java.net.URLEncoder

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object WebView : NavRoutes("webview/{url}") {
        fun createRoute(url: String): String {
            return "webview/${URLEncoder.encode(url, "UTF-8")}"
        }
    }
}