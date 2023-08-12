package com.edu.teachingnepal.features.outerscreen.register

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Surface
import androidx.compose.material.TextButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.outerscreen.ScreenList
import com.edu.teachingnepal.features.util.ui.DividerWithText
import com.edu.teachingnepal.features.util.ui.ImageViewPainter
import com.edu.teachingnepal.features.util.ui.MaterialButton
import com.edu.teachingnepal.features.util.ui.OutlineTextFields
import com.edu.teachingnepal.features.util.ui.PasswordTextField
import com.edu.teachingnepal.features.util.ui.TextButtonWithImageIcon
import com.edu.teachingnepal.features.util.ui.TextView

val registerViewModel = RegisterViewModel()
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterViewScreen(navController: NavHostController) {

    val context = LocalContext.current
    // items list
    val listOfPersons = arrayOf("I am a Student", "I am a Parent")
    val listOfGrades = arrayOf("Grade 12", "Grade 11", "Grade 10", "Grade_review")

    // state of the menu
    var expandedPerson by remember { mutableStateOf(false) }
    var expandedGrade by remember { mutableStateOf(false) }

    // remember the selected item
    var selectedPersonItem by remember { mutableStateOf(listOfPersons[0]) }
    var selectedGradeItem by remember { mutableStateOf(listOfGrades[0]) }

    // text fields
    var name by remember { mutableStateOf("") }
    var nameErrorMessage by remember { mutableStateOf(false) }
    var nameEmptyMessage by remember { mutableStateOf(false) }
    val isNameEmpty by remember {
        derivedStateOf { name.isEmpty() }
    }

    var email by remember { mutableStateOf("") }
    var emailErrorMessage by remember { mutableStateOf(false) }
    var emailEmptyMessage by remember { mutableStateOf(false) }
    val isEmailEmpty by remember {
        derivedStateOf { email.isEmpty() }
    }

    var password by remember { mutableStateOf("") }
    var passwordEmptyMessage by remember { mutableStateOf(false) }
    val isPasswordEmpty by remember {
        derivedStateOf {
            password.isEmpty()
        }
    }

    // register button onClickAction
    val onClickAction = {
        // name error message
        nameEmptyMessage = isNameEmpty
        // email error message
        emailEmptyMessage = isEmailEmpty
        // password error message
        passwordEmptyMessage = isPasswordEmpty

        if(!isNameEmpty && !isEmailEmpty && !isPasswordEmpty ){
            val isSuccess = registerViewModel.registerDetails(name, email, password, context)
            if (isSuccess) {
                Toast.makeText(context, "Register success", Toast.LENGTH_SHORT).show()
                navController.navigate(ScreenList.LoginScreen.route) // navigate
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
            ImageViewPainter(painterImage = painterResource(id = R.drawable.img_teaching_nepal))

            Spacer(modifier = Modifier.padding(top = 30.dp))
            TextView(
                text = "Register as a Student for FREE!",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    lineHeight = 30.sp
                ),
                modifier = Modifier
            )

            Spacer(modifier = Modifier.padding(top = 30.dp))
            // dropdown options
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // student or parent
                ExposedDropdownMenuBox(
                    expanded = expandedPerson,
                    onExpandedChange = { expandedPerson = !expandedPerson }
                ) {
                    // text field
                    OutlinedTextField(
                        value = selectedPersonItem,
                        onValueChange = { selectedPersonItem = it },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedPerson)
                        },
                        textStyle = TextStyle(fontSize = 14.sp),
                        readOnly = true,
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.width(160.dp)
                    )

                    // menu
                    ExposedDropdownMenu(
                        expanded = expandedPerson,
                        onDismissRequest = { expandedPerson = false }
                    ) {
                        // all the items are added vertically
                        listOfPersons.forEach { selectedOption ->
                            // menu item
                            DropdownMenuItem(
                                onClick = {
                                    selectedPersonItem = selectedOption
                                    expandedPerson = false
                                }
                            ) {
                                TextView(
                                    text = selectedOption,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Color.Black,
                                        lineHeight = 20.sp,
                                    ),
                                    modifier = Modifier
                                )
//                                RegularText(text = selectedOption, color = Color.Black)
                            }
                        }
                    }
                }

                // grade level
                ExposedDropdownMenuBox(
                    expanded = expandedGrade,
                    onExpandedChange = { expandedGrade = !expandedGrade }
                ) {
                    // text field
                    OutlinedTextField(
                        value = selectedGradeItem,
                        onValueChange = { selectedGradeItem = it },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedGrade)
                        },
                        textStyle = TextStyle(fontSize = 14.sp),
                        readOnly = true,
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.width(160.dp)
                    )
                    // menu
                    ExposedDropdownMenu(
                        expanded = expandedGrade,
                        onDismissRequest = { expandedGrade = false }
                    ) {
                        // all the items are added vertically
                        listOfGrades.forEach { selectedOption ->
                            // menu item
                            DropdownMenuItem(
                                onClick = {
                                    selectedGradeItem = selectedOption
                                    expandedGrade = false
                                }
                            ) {
                                TextView(
                                    text = selectedOption,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Color.Black,
                                        lineHeight = 20.sp,
                                    ),
                                    modifier = Modifier
                                )
//                                RegularText(text = selectedOption, color = Color.Black)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(top = 20.dp))
            OutlineTextFields(
                value = name,
                onValueChange = { name = it },
                placeholder = "Full Name",
                isEmpty = nameEmptyMessage,
                isError = nameErrorMessage,
                invalidMessage = "Enter the valid username"
            )

            Spacer(modifier = Modifier.padding(top = 20.dp))
            OutlineTextFields(
                value = email,
                onValueChange = { email = it },
                placeholder = "Enter Email",
                isEmpty = emailEmptyMessage,
                isError = emailErrorMessage,
                invalidMessage = "Enter the valid email address"
            )

            Spacer(modifier = Modifier.padding(top = 20.dp))
            PasswordTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Enter Password",
                isEmpty = passwordEmptyMessage
            )

            Spacer(modifier = Modifier.padding(top = 20.dp))
            MaterialButton(text = "Create My account", onClick = onClickAction)

            Spacer(modifier = Modifier.padding(top = 15.dp))
            DividerWithText(text = "OR")

            Spacer(modifier = Modifier.padding(top = 15.dp))
            TextButtonWithImageIcon(
                painter = painterResource(id = R.drawable.img_google),
                buttonText = "Sing up with Google",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    lineHeight = 24.sp
                ),
                onClick = { }
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))
            TextButtonWithImageIcon(
                painter = painterResource(id = R.drawable.img_facebook),
                buttonText = "Sing up with Facebook",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    lineHeight = 24.sp,
                ),
                onClick = {}
            )

            Spacer(modifier = Modifier.padding(top = 30.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                TextView(
                    text = "For Teacher and Principals who want to use the platform, send an email at: learn@mysecondteacher.com",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 15.sp,
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                )
            }

            Spacer(modifier = Modifier.padding(top = 30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextView(
                    text = "Already Have An Account?",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 20.sp
                    ),
                    modifier = Modifier
                )
                TextButton(
                    modifier = Modifier.wrapContentWidth(),
                    onClick = {
                         navController.navigate(ScreenList.LoginScreen.route)
                    },
                ) {
                    TextView(
                        text = "Login Now",
                        style = TextStyle(
                            color = colorResource(id = R.color.purple_200),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 24.sp
                        ),
                        modifier = Modifier
                    )
                }
            }
            Spacer(modifier = Modifier.padding(bottom = 30.dp))
        }
    }
}