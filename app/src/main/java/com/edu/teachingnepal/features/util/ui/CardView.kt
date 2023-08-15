package com.edu.teachingnepal.features.util.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Note
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.teachingnepal.features.util.ui.TextView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardViewSingleTask(imageVector: ImageVector,text: String, color: Color, onClick: () -> Unit = {}) {
    Card(onClick = onClick, modifier = Modifier.padding()) {
        Row(
            modifier = Modifier
                .fillMaxWidth().background(color.copy(alpha = 0.10f))
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = imageVector, contentDescription = null)
            TextView(
                text = text,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Default
                ),
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

/**
 * @param title: String
 * @param description: String
 * @param icon: ImageVector
 * @param color: Color
 * @param onClick: action listener
 * this is the card view function where single text parameter
 * text: String, onClick: () -> Unit = {}
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardViewMultiTask(
    icon: ImageVector,
    title: String,
    description: String,
    color: Color,
    onClick: () -> Unit = {}
) {
    val transparentColor = color.copy(alpha = 0.10f) // Create a new color with 25% alpha
    Card(
        onClick = onClick,
        modifier = Modifier.padding(top = 10.dp).background(Color.Unspecified)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth().background(transparentColor)
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = icon, contentDescription = null, tint = color)
                TextView(
                    text = title,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Default,
                        color = color
                    ),
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            TextView(
                text = description,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    color = Color.DarkGray
                ),
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}