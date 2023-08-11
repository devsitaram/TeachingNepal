package com.edu.teachingnepal.features.util.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * the given text are heading and title text
 * fontSize, fontWeight, color and also lineHeight
 * it it reusable component
 */
// Title 1
@Composable
fun LargeTitle1(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        ),
        color = color,
        lineHeight = 40.sp,
    )
}

// Title 2
@Composable
fun Title2(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default
        ),
        color = color,
        lineHeight = 40.sp,
    )
}

// Title 3
@Composable
fun Title3(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        ),
        color = color,
        lineHeight = 40.sp,
    )
}

// Title 4
@Composable
fun Title4(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        ),
        color = color,
        lineHeight = 24.sp,
    )
}

// HEADLINE
@Composable
fun HEADLINE(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        ),
        color = color,
        lineHeight = 20.sp,
    )
}

/**
 * the given below text component are Text which is using for paragraph, normal text etc.
 * fontSize, fontWeight, color and also lineHeight
 * it it reusable component
 */
// Extra Large Text
@Composable
fun ExtraLargeText(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        ),
        color = color,
        lineHeight = 24.sp,
    )
}

// Large Text Bold
@Composable
fun LargeTextBold(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),
        color = color,
        lineHeight = 24.sp,
    )
}

// Large Text SemiBold
@Composable
fun LargeTextSemiBold(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        ),
        color = color,
        lineHeight = 24.sp,
    )
}

// Large Text
@Composable
fun LargeText(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        color = color,
        lineHeight = 24.sp,
    )
}

// Regular Text Bold
@Composable
fun RegularTextBold(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        ),
        color = color,
        lineHeight = 40.sp,
    )
}


// Regular Text SemiBold
@Composable
fun RegularTextSemiBold(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        ),
        color = color,
        lineHeight = 20.sp,
    )
}

// Regular Text
@Composable
fun RegularText(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        ),
        color = color,
        lineHeight = 20.sp,
    )
}

// Small Text Bold
@Composable
fun SmallTextBold(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        ),
        color = color,
        lineHeight = 16.sp,
    )
}

// Small Text SemiBold
@Composable
fun SmallTextSemiBold(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        ),
        color = color,
        lineHeight = 16.sp,
    )
}

// small text
@Composable
fun SmallText(text: String, color: Color) {
    Text(text = text,
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Default,
            color = color
        ),
        modifier = Modifier.padding(top = 5.dp)
    )
}

/**
 * the given below three text component are Button Text
 * fontSize, fontWeight, color and also lineHeight
 * it it reusable component
 */
// Large Button Text
@Composable
fun LargeButtonText(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        ),
        color = color,
        lineHeight = 24.sp,
    )
}

// Medium Button Text
@Composable
fun MediumButtonText(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        ),
        color = color,
        lineHeight = 24.sp,
    )
}

// Small Button Text
@Composable
fun SmallButtonText(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        ),
        color = color,
        lineHeight = 24.sp,
    )
}

/**
 * the given below text are using for input text fields
 * fontSize, fontWeight, color and also lineHeight
 * it it reusable component
 */
// label
@Composable
fun LabelText(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        ),
        color = color,
        lineHeight = 16.sp,
    )
}

// Input Text
@Composable
fun InputText(text: String, color: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        ),
        color = color,
        lineHeight = 24.sp,
    )
}