package com.edu.teachingnepal.features.outerscreen.login

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun LoginViewScreen(navController: NavHostController) {

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    // Retrieve the values from SharedPreferences
    val hasViewedOuterScreen = sharedPreferences.getString("outer_screen", "")

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login View")

        Button(onClick = {
            // Save the preference to indicate that the user has viewed the outer screen
            val editor = sharedPreferences.edit()
            editor.putString("outer_screen", "sitaram")
            editor.apply()
        }) {
            Text(text = "Login")
        }

        // Display the retrieved values
        Text(text = "hasViewedOuterScreen: $hasViewedOuterScreen")
    }
}