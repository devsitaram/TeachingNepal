package com.edu.teachingnepal.ui.theme.navigate

sealed class Screen(val route: String) {
    object SplashScreen : Screen("SplashScreen")
    object MainScreen : Screen("MainScreen")
}