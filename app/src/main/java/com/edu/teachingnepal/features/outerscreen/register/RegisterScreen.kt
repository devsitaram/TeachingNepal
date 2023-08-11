package com.edu.teachingnepal.features.outerscreen.register

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
import androidx.compose.material.TextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import com.edu.teachingnepal.features.util.ui.Title2

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterViewScreen(navController: NavHostController) {

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
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val onClickAction = {

    }

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
            Title2(text = "Register as a Student for FREE!", color = Color.Black)


            // dropdown options
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
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
                        readOnly = true,
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.width(150.dp)
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
                                RegularText(text = selectedOption, color = Color.Black)
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
                        readOnly = true,
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.width(150.dp)
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
                                RegularText(text = selectedOption, color = Color.Black)
                            }
                        }
                    }
                }
            }




            Spacer(modifier = Modifier.padding(top = 40.dp))
            OutlineTextFields(
                value = email,
                onValueChange = { email = it },
                placeholder = "Enter Email",
                isError = false,
                isEmpty = false
            )

            Spacer(modifier = Modifier.padding(top = 15.dp))
            PasswordTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Enter Password",
                isEmpty = false
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
                RegularText(text = "Already Have An Account?", color = Color.Gray)
                TextButton(
                    modifier = Modifier.wrapContentWidth(),
                    onClick = { navController.navigate(ScreenList.LoginScreen.route) },
                ) {
                    MediumButtonText(
                        text = "Login Now",
                        color = colorResource(id = R.color.purple_200)
                    )
                }
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