package com.edu.teachingnepal.features.outerscreen.forgotpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.util.ui.ImageViewPainter
import com.edu.teachingnepal.features.util.ui.MaterialButton
import com.edu.teachingnepal.features.util.ui.OutlineTextFields
import com.edu.teachingnepal.features.util.ui.TextView

val forgotPasswordViewModel = ForgotPasswordViewModel()

@Composable
fun ForgotPasswordViewScreen(navController: NavHostController) {

    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var emailErrorMessage by remember { mutableStateOf(false) }
    var emailEmptyMessage by remember { mutableStateOf(false) }
    val isEmailEmpty by remember {
        derivedStateOf {
            email.isEmpty()
        }
    }

    val onClickAction: () -> Unit = {
        if (isEmailEmpty){
            emailErrorMessage = false
        }
        emailEmptyMessage = isEmailEmpty
        if (!isEmailEmpty) {
            val isSuccess = forgotPasswordViewModel.resetPassword(email, context)
            if (isSuccess) {
                navController.navigateUp()
            } else {
                emailErrorMessage = true
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().background(Color.White)
                .padding(top = 15.dp), horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = { navController.navigateUp() } ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .verticalScroll(rememberScrollState())
                .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageViewPainter(
                painterImage = painterResource(id = R.mipmap.img_teaching_nepal),
                modifier = Modifier.padding(top = 30.dp)
            )

            ImageViewPainter(
                painterImage = painterResource(id = R.mipmap.img_resetpassword),
                modifier = Modifier.padding(top = 70.dp)
            )

            TextView(
                text = "Forgot your Password?",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 30.dp)
            )

            TextView(
                text = "Don't worry! We are here to help you. Enter you email address below to reset your password.",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp,
                    color = Color.Gray
                ),
                modifier = Modifier.padding(top = 30.dp, bottom = 30.dp)
            )

            OutlineTextFields(
                value = email,
                onValueChange = { email = it },
                placeholder = "Enter Email",
                isEmpty = emailEmptyMessage,
                isError = emailErrorMessage,
                invalidMessage = "Enter the valid email address"
            )

            MaterialButton(
                text = "Reset Password",
                onClick = onClickAction,
                modifier = Modifier
                    .padding(top = 35.dp)
                    .width(170.dp)
            )
        }
    }
}