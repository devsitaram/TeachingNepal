package com.edu.teachingnepal.features.outerscreen

sealed class ScreenList(val route: String) {
    object SplashScreen : ScreenList("SplashScreen")
    object LoginScreen : ScreenList("LoginScreen")
    object SignUpScreen : ScreenList("SignUpScreen")
    object ForgotPassword : ScreenList("ForgotPassword")
    object MainScreen : ScreenList("MainScreen")
}