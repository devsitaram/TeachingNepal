package com.edu.teachingnepal.features.outerscreen.login

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.TextButton
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ShapeDefaults
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
import com.edu.teachingnepal.features.util.ui.SmallText
import com.edu.teachingnepal.features.util.ui.TextButtonWithImageIcon
import com.edu.teachingnepal.features.util.ui.TextView
import com.edu.teachingnepal.features.util.ui.Title3

//@Preview
@Composable
fun LoginViewScreen(navController: NavHostController) {

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    val loginViewModel = LoginViewModel()

    var email by remember { mutableStateOf("") }
    var emailErrorMessage by remember { mutableStateOf(false) }
    var emailEmptyMessage by remember { mutableStateOf(false) }
    val isEmailEmpty by remember {
        derivedStateOf {
            email.isEmpty()
        }
    }

    var password by remember { mutableStateOf("") }
    var passwordEmptyMessage by remember { mutableStateOf(false) }
    val isPasswordEmpty by remember {
        derivedStateOf {
            password.isEmpty()
        }
    }

    val onClickAction: () -> Unit = {
        if (isEmailEmpty){
            emailErrorMessage = false
        }
        emailEmptyMessage = isEmailEmpty
        passwordEmptyMessage = isPasswordEmpty

        if (!isEmailEmpty && !isPasswordEmpty) {
            val isSuccess = loginViewModel.loginDetails(email, password, context)
            if (isSuccess) {
                // share preference
                val editor = sharedPreferences.edit()
                editor.putString("outer_screen", "this").apply()
                navController.navigate(ScreenList.MainScreen.route) // navigate
            } else {
                emailErrorMessage = true
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(modifier = Modifier.padding(top = 30.dp))
            ImageViewPainter(
                painterImage = painterResource(id = R.mipmap.img_teaching_nepal),
                modifier = Modifier
                    .background(color = Color.White)
                    .wrapContentWidth()
            )

            Spacer(modifier = Modifier.padding(top = 30.dp))
            Title3(text = "Sing in to your account", color = Color.Black)

            Spacer(modifier = Modifier.padding(top = 40.dp))
            OutlineTextFields(
                value = email,
                onValueChange = { email = it },
                placeholder = "Enter Email",
                isEmpty = emailEmptyMessage,
                isError = emailErrorMessage,
                invalidMessage = "Enter the valid email address"
            )

            Spacer(modifier = Modifier.padding(top = 15.dp))
            PasswordTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Enter Password",
                isEmpty = passwordEmptyMessage
            )

            Spacer(modifier = Modifier.padding(top = 15.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                TextButton(
                    modifier = Modifier.wrapContentWidth(),
                    onClick = {
                       navController.navigate(ScreenList.ForgotPassword.route)
                    },
                ) {
                    MediumButtonText(
                        text = "Forgot Your Password?",
                        color = colorResource(id = R.color.purple_200)
                    )
                }
            }

            // login button
            MaterialButton(
                text = "Sign In",
                onClick = onClickAction,
                        modifier = Modifier.padding(top = 15.dp)
            )

            Spacer(modifier = Modifier.padding(top = 15.dp))
            DividerWithText(text = "OR")

            Spacer(modifier = Modifier.padding(top = 15.dp))
            TextButtonWithImageIcon(
                painter = painterResource(id = R.mipmap.img_google),
                buttonText = "Sing up with Google",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    lineHeight = 24.sp

                ),
                onClick = {}
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))
            TextButtonWithImageIcon(
                painter = painterResource(id = R.mipmap.img_facebook),
                buttonText = "Sing up with Facebook",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    lineHeight = 24.sp
                ),
                onClick = { }
            )

            Spacer(modifier = Modifier.padding(top = 20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RegularText(text = "Don't have an account?", color = Color.Gray)
                TextButton(
                    modifier = Modifier.wrapContentWidth(),
                    onClick = {
                        navController.navigate(ScreenList.SignUpScreen.route)
                    },
                ) {
                    MediumButtonText(
                        text = "Register Now !",
                        color = colorResource(id = R.color.purple_200)
                    )
                }
            }

            Divider(modifier = Modifier.padding(top = 10.dp))
            Spacer(modifier = Modifier.padding(top = 25.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SmallText(text = "Download our Guides", color = Color.Gray)
            }

            Spacer(modifier = Modifier.padding(top = 15.dp))
            BottomListImage(onClickAction = {} )
        }
    }
}

@Preview
@Composable
fun BottomListImage(onClickAction:()->Unit ={}) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                shape = ShapeDefaults.Small,
                modifier = Modifier
                    .wrapContentWidth()
                    .clickable { onClickAction() },
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .wrapContentWidth()
                        .width(IntrinsicSize.Max), // Set the width to the maximum intrinsic width
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.End
                ) {
                    Column(
                        modifier = Modifier
                            .width(60.dp)
                            .padding(top = 5.dp, start = 5.dp)
                    ) {
                        TextView(
                            text = "For Awesome Students",
                            style = TextStyle(
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.splash)
                            ),
                            modifier = Modifier.wrapContentWidth()
                        )
                        TextView(
                            text = "Download our Guide",
                            style = TextStyle(
                                fontSize = 5.sp,
                                color = Color.Gray
                            ),
                            modifier = Modifier.wrapContentWidth()
                        )
                    }
                    ImageViewPainter(
                        painterImage = painterResource(id = R.mipmap.img_student),
                        modifier = Modifier
                            .background(color = Color.White)
                            .height(50.dp).padding(end = 5.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(5.dp))
            Card(
                shape = ShapeDefaults.Small,
                modifier = Modifier
                    .wrapContentWidth()
                    .clickable { onClickAction() },
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .wrapContentWidth()
                        .width(IntrinsicSize.Max), // Set the width to the maximum intrinsic width
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Start
                ) {
                    ImageViewPainter(
                        painterImage = painterResource(id = R.mipmap.img_parent),
                        modifier = Modifier
                            .background(color = Color.White)
                            .height(50.dp).padding(start = 5.dp)
                    )
                    Column(
                        modifier = Modifier
                            .width(65.dp)
                            .padding(top = 5.dp, end = 5.dp)
                    ) {
                        TextView(
                            text = "For Responsible Teacher",
                            style = TextStyle(
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.splash)
                            ),
                            modifier = Modifier.wrapContentWidth()
                        )
                        TextView(
                            text = "Download our Guide",
                            style = TextStyle(
                                fontSize = 5.sp,
                                color = Color.Gray
                            ),
                            modifier = Modifier.wrapContentWidth()
                        )
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 20.dp))
}