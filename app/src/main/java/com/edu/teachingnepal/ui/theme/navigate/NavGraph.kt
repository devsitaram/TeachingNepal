package com.edu.teachingnepal.ui.theme.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edu.teachingnepal.features.main.MainViewScreen

@Composable
fun NavGraphView(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(Screen.SplashScreen.route){
            SplashScreen()
        }
        composable(Screen.MainScreen.route){
            MainViewScreen()
        }
    }
}