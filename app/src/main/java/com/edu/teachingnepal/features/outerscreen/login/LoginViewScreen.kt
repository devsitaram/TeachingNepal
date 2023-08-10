package com.edu.teachingnepal.features.outerscreen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.outerscreen.ScreenList
import com.edu.teachingnepal.features.util.ui.DividerWithText
import com.edu.teachingnepal.features.util.ui.ImageViewPainter
import com.edu.teachingnepal.features.util.ui.MaterialButton
import com.edu.teachingnepal.features.util.ui.MediumButtonText
import com.edu.teachingnepal.features.util.ui.OutlineTextFields
import com.edu.teachingnepal.features.util.ui.PasswordTextField
import com.edu.teachingnepal.features.util.ui.RegularText
import com.edu.teachingnepal.features.util.ui.TextButtonWithImageIcon
import com.edu.teachingnepal.features.util.ui.Title3

@Composable
fun LoginViewScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val onClickAction = { }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            ImageViewPainter(painterImage = painterResource(id = R.drawable.img_teaching_nepal))

            Spacer(modifier = Modifier.padding(top = 30.dp))
            Title3(text = "Sing in to your account", color = Color.Black)

            Spacer(modifier = Modifier.padding(top = 40.dp))
            OutlineTextFields(
                value = email,
                onValueChange = { email = it },
                placeholder = "Enter Email"
            )

            Spacer(modifier = Modifier.padding(top = 15.dp))
            PasswordTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Enter Password"
            )

            Spacer(modifier = Modifier.padding(top = 15.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                TextButton(
                    modifier = Modifier.wrapContentWidth(),
                    onClick = { ScreenList.ForgotPassword.route },
                ) {
                    MediumButtonText(
                        text = "Forgot Your Password?",
                        color = colorResource(id = R.color.purple_200)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 15.dp))
            MaterialButton(text = "Sign In", onClick = onClickAction)

            Spacer(modifier = Modifier.padding(top = 15.dp))
            DividerWithText(text = "OR")

            Spacer(modifier = Modifier.padding(top = 15.dp))
            TextButtonWithImageIcon(
                painter = painterResource(id = R.drawable.img_google),
                buttonText = "Sing up with Google",
                onClick = {}
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))
            TextButtonWithImageIcon(
                painter = painterResource(id = R.drawable.img_facebook),
                buttonText = "Sing up with Facebook",
                onClick = {}
            )

            Spacer(modifier = Modifier.padding(top = 35.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                RegularText(text = "Don't have an account?", color = Color.Gray)
                Spacer(modifier = Modifier.width(5.dp))
                RegularText(
                    text = "Register Now !",
                    color = colorResource(id = R.color.purple_200)
                )
            }

            Divider(modifier = Modifier.padding(top = 25.dp))
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(text = "Download our Guides", fontSize = 12.sp, color = Color.Gray)
            }

        }
    }
}


//val context = LocalContext.current
//val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
//
//            Button(
//                onClick = {
//                    // Save the preference to indicate that the user has viewed the outer screen
//                    val editor = sharedPreferences.edit()
//                    editor.putString("outer_screen", "sitaram").apply()
//                }) {
//                Text(text = "Login")
//            }