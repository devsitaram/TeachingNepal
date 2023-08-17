package com.edu.teachingnepal.features.util.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Note
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.util.ui.TextView
import com.edu.teachingnepal.ui.theme.skyBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardViewSingleTask(
    imageVector: ImageVector,
    text: String,
    color: Color,
    onClick: () -> Unit = {}
) {
    Card(onClick = onClick, modifier = Modifier.padding()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color.copy(alpha = 0.10f))
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
        modifier = Modifier
            .padding(top = 10.dp)
            .background(Color.Unspecified)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(transparentColor)
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

@Composable
fun ContentCardView(painter: Painter, topic: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth().padding(bottom = 15.dp)
            .border(1.dp, Color.LightGray), shape = ShapeDefaults.Medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(start = 15.dp, end = 15.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.LightGray),
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    TextView(
                        text = topic, style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                        modifier = Modifier
                    )
                    TextView(
                        text = description,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 20.sp,
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.LightGray)
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Newspaper,
                        contentDescription = null,
                        tint = skyBlue,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    TextView(
                        text = "View Package Detail", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = skyBlue
                        ),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
    }
}