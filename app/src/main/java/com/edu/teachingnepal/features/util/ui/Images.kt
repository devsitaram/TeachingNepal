package com.edu.teachingnepal.features.util.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

/**
 * this is the : painter image function
 * painter image parameter
 */
@Composable
fun ImageViewPainter(painterImage: Painter, modifier: Modifier) {
    Image(
        painter = painterImage,
        contentDescription = null,
        modifier = modifier,
    )
}