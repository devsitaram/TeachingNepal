package com.edu.teachingnepal.features.util.ui

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun IconViewPainter(painter: Painter, modifier: Modifier) {
    Icon(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
    )
}