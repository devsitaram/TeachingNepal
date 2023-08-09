package com.edu.teachingnepal.features.innerscreen

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainViewScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            MainHomeViewScreen()
        }
    }
}

@Composable
fun MainHomeViewScreen() {
    val context = LocalContext.current
    val activity = (LocalContext.current as Activity)
    val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    // Retrieve the values from SharedPreferences
    val hasViewedOuterScreen = sharedPreferences.getString("outer_screen", "")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home")
        Button(onClick = {
            // Save the preference to indicate that the user has viewed the outer screen
            val editor = sharedPreferences.edit()
            editor.putString("outer_screen", "")
            editor.apply()
            activity.isDestroyed
        }) {
            Text(text = "Log out")
        }
    }
}
