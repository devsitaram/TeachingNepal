package com.edu.teachingnepal.features.innerscreen.subject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.edu.teachingnepal.features.util.ui.CircularIndicator
import com.edu.teachingnepal.ui.theme.pink

@Composable
fun MyLibraryViewScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularIndicator(color = pink, modifier = Modifier.size(50.dp))
    }
}