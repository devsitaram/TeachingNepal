package com.edu.teachingnepal.features.innerscreen.subject.mststore

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun SubjectDetailsViewScreen(
    navController: NavHostController,
    subjectDetailsViewModel: SubjectDetailsViewModel,
) {
    val subject = subjectDetailsViewModel.subjectDetails

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
    ) {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.Gray
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TextView(
                text = "${subject?.topic}",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(top = 50.dp)
            )
            Card(
                modifier = Modifier.fillMaxWidth().height(275.dp).padding(top = 15.dp, bottom = 15.dp)
            ) {
                ImageViewPainter(
                    painterImage = painterResource(id = R.mipmap.img_10_economic),
                    modifier = Modifier.size(180.dp).padding(30.dp)
                )
            }
            TextView(
                text = "${subject?.description}",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}