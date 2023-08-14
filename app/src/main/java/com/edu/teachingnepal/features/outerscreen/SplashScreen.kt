package com.edu.teachingnepal.features.outerscreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.util.ui.ImageViewPainter
import com.edu.teachingnepal.features.util.ui.TextView
import com.edu.teachingnepal.ui.theme.splash
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController, getDeviceUser: String?) {

    var startAnimate by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2500
        ),
    )

    LaunchedEffect(key1 = true) {
        startAnimate = true
        delay(3000)
        if (getDeviceUser == null || getDeviceUser != "this") {
            navController.navigate(ScreenList.LoginScreen.route)
        } else {
            navController.navigate(ScreenList.MainScreenList.route)
        }
    }
    SplashScreen(alpha = alphaAnim.value)
}

@Composable
fun SplashScreen(alpha: Float) {
    Surface(Modifier.background(color = MaterialTheme.colors.background)) {
        Box(
            modifier = Modifier
                .background(splash)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(alpha = alpha),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageViewPainter(
                    painterImage = painterResource(id = R.drawable.img_splash),
                    modifier = Modifier.size(120.dp),
                )
                TextView(
                    text = "Education Nepal",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Default,
                        color = Color.White,
                        lineHeight = 40.sp
                    ),
                    modifier = Modifier
                )
            }
            if (alpha != 1f) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp),
                    color = Color.White,
                    strokeWidth = 5.dp
                )
            }
        }
    }
}

//@Composable
//fun AnimatedSplashScreen(navController: NavHostController) {
//
//    var startAnimate by remember { mutableStateOf(false) }
//    val alphaAnim = animateFloatAsState(
//        targetValue = if (startAnimate) 1f else 0.1f,
//        animationSpec = tween(
//            durationMillis = 3000
//        ),
//    )
//
//    LaunchedEffect(key1 = true) {
//        startAnimate = true
//        delay(4000)
//        navController.navigate(ScreenList.MainScreenList.route)
//    }
//
//    SplashScreen(alpha = alphaAnim.value)
//}
//
//@Composable
//fun SplashScreen(alpha: Float) {
//    Surface(Modifier.background(color = MaterialTheme.colors.background)) {
//        Box(
//            modifier = Modifier
//                .background(splash)
//                .alpha(alpha = alpha)
//                .fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .alpha(alpha = alpha),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    modifier = Modifier.size(120.dp),
//                    painter = painterResource(id = R.drawable.img_splash),
//                    contentDescription = "splash icon",
//                )
//                Title2(text = "Education Nepal", color = Color.White)
//            }
//        }
//    }
//}

//@Preview
//@Composable
//fun SplashScreenPreview() {
//    SplashScreen(alpha = 1f)
//}
//
//@Preview(uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun SplashScreenDarkPreview() {
//    SplashScreen(alpha = 1f)
//}