package com.edu.teachingnepal.features.innerscreen.subject

import android.media.MediaPlayer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.edu.teachingnepal.R

@Composable
fun SubjectViewScreen() {

//    val context = LocalContext.current
//    var mediaPlayer = MediaPlayer.create(context, R.raw.sound)
//
//    Surface(modifier = Modifier.fillMaxSize()) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "Subject")
//
//            // Your button content here
//            Button(onClick = { mediaPlayer.start() }) {
//                Text(text = "Ok")
//            }
//
//            DisposableEffect(Unit) {
//                onDispose {
//                    mediaPlayer.release()
//                }
//            }
//        }
//    }
}

@Composable
fun TabScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Home", "About", "Settings")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { androidx.compose.material3.Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> HomeScreen()
            1 -> AboutScreen()
            2 -> SettingsScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        androidx.compose.material3.Text(text = "Home")
    }
}

@Composable
fun AboutScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        androidx.compose.material3.Text(text = "About")
    }
}

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        androidx.compose.material3.Text(text = "Setting")
    }
}