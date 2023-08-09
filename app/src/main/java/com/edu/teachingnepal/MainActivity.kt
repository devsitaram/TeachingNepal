package com.edu.teachingnepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edu.teachingnepal.features.innerscreen.MainViewScreen
import com.edu.teachingnepal.features.outerscreen.AnimatedSplashScreen
import com.edu.teachingnepal.features.outerscreen.ScreenList
import com.edu.teachingnepal.features.outerscreen.login.LoginViewScreen
import com.edu.teachingnepal.ui.theme.TeachingNepalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    val getSharedPreferences = getSharedPreferences("selfPrefs", MODE_PRIVATE)
        val getDevice = getSharedPreferences.getBoolean("outer_screen", false)
//    val hasIntroSlider: Boolean = getSharedPreferences.getBoolean("has_view_slider", false)

        setContent {
            TeachingNepalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = ScreenList.SplashScreenList.route){

                        composable(ScreenList.SplashScreenList.route){
                            AnimatedSplashScreen(navController, getDevice)
                        }

                        composable(ScreenList.LoginScreen.route){
                            LoginViewScreen(navController)
                        }

                        composable(ScreenList.SignUpScreen.route){
//                            AnimatedSplashScreen(navController)
                        }

                        composable(ScreenList.ForgotPassword.route){
//                            AnimatedSplashScreen(navController)
                        }

                        composable(ScreenList.MainScreenList.route){
                            MainViewScreen()
                        }
                    }
                }
            }
        }
    }
}

