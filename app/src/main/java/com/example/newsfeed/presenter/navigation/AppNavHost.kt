package com.example.newsfeed.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsfeed.presenter.screen.NewsScreen
import com.example.newsfeed.presenter.screen.WebViewScreen
import java.net.URLDecoder

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
    ) {
        // Home screen
        composable(NavRoutes.Home.route) {
            NewsScreen(){it->
                navController.navigate(NavRoutes.WebView.createRoute(it.articleUrl))
            }
        }

        // Webview screen
        composable(NavRoutes.WebView.route) { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("url") ?: ""
            val url = URLDecoder.decode(encodedUrl, "UTF-8")
            WebViewScreen(url = url){
                navController.popBackStack()
            }
        }
    }
}
