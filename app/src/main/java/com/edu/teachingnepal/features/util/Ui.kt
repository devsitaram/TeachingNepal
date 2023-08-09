package com.edu.teachingnepal.features.util

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * the text is: Title 2
 * fontSize, fontWeight, color and also lineHeight
 * it it reusable component
 */
@Composable
fun Title2(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ),
        color = color,
        lineHeight = 40.sp,
    )
}