package com.edu.teachingnepal.ui.theme.navigate

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.ui.theme.splash
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimate by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimate = true
        delay(3000)
        navController.navigate(Screen.MainScreen.route)
    }

    SplashScreen(alpha = alphaAnim.value)
}

@Composable
fun SplashScreen(alpha: Float) {
    Surface(Modifier.background(color = MaterialTheme.colors.background)) {
        Box(
            modifier = Modifier
                .background(splash)
                .alpha(alpha = alpha)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = R.drawable.img_splash),
                contentDescription = "splash icon",
            )
        }
    }
}

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