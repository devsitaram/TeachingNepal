package com.edu.teachingnepal.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainViewScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ""){
        composable(""){

        }
    }
}