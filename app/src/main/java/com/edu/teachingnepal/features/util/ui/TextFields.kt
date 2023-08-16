package com.edu.teachingnepal.features.util.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.teachingnepal.R

// normal text fields
@Composable
fun OutlineTextFields(
    value: String,
    onValueChange: (String) -> Unit = {},
    placeholder: String,
    isEmpty: Boolean,
    isError: Boolean,
    invalidMessage: String
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                TextView(
                    text = placeholder,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 24.sp
                    ),
                    modifier = Modifier
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,
            isError = (isEmpty || isError),
            modifier = Modifier.fillMaxWidth()
        )
        if (isEmpty) {
            SmallText(text = "The field is required", color = Color.Red)
        }
        if (isError) {
            SmallText(text = invalidMessage, color = Color.Red)
        }
    }
}

// password text fields
@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit = {},
    placeholder: String,
    isEmpty: Boolean
) {
    val passwordVisibility = remember { mutableStateOf(false) }
    var color by remember { mutableStateOf(Color.Transparent) }

    color = if (isEmpty) {
        Color.Red
    } else {
        Color.Transparent
    }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            TextView(
                text = placeholder,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 24.sp
                ),
                modifier = Modifier
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        trailingIcon = {
            IconButton(
                onClick = { passwordVisibility.value = !passwordVisibility.value }
            ) {
                Icon(
                    painter = if (passwordVisibility.value) painterResource(id = R.drawable.ic_visibility) else painterResource(
                        id = R.drawable.ic_visibility_off
                    ),
                    contentDescription = "visibility",
                )
            }
        },
        isError = isEmpty,
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        // Changed the border to 1dp and adjusted border color
        modifier = Modifier.fillMaxWidth(),
    )

    if (isEmpty) {
        SmallText(text = "The field is required", color = color)
    }
}


//@Composable
//fun DropdownFunction() {
//    val listOfSubject = arrayOf("Subjects", "Assets", "Levels")
//    // state of the menu
//    var expandedSubject by remember { mutableStateOf(false) }
//    // remember the selected item
//    var selectedSubjectItem by remember { mutableStateOf(itemsList[0]) }
//
//    DropDownTextFieldView(
//        itemsList = itemsList,
//        expanded = expanded,
//        selectedItem = selectedItem,
//        onExpandedChange = { expanded = !expanded },
//        onValueChange = { selectedItem = it }
//    ) { expanded = false }
//}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownTextFieldView(
    itemsList: Array<String>,
    expanded: Boolean,
    selectedItem: String,
    onExpandedChange: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit = {},
    onDismissRequest: () -> Unit = {}
) {
    // Use state variables to handle mutable state
    var localExpanded by remember { mutableStateOf(expanded) }
    var localSelectedItem by remember { mutableStateOf(selectedItem) }
    val keyboardController = LocalSoftwareKeyboardController.current

    // text fields
    ExposedDropdownMenuBox(
        expanded = localExpanded,
        onExpandedChange = {
            localExpanded = it
            onExpandedChange(it)
        }
    ) {
        // menu
        ExposedDropdownMenu(
            expanded = localExpanded,
            onDismissRequest = {
                localExpanded = false
                onDismissRequest()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            // all the items are added vertically
            itemsList.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(
                    onClick = {
                        localSelectedItem = selectedOption
                        localExpanded = false
                        onValueChange(selectedOption)
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
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        // text field
        OutlinedTextField(
            value = localSelectedItem,
            onValueChange = { newValue ->
                localSelectedItem = newValue
                onValueChange(newValue)
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = localExpanded)
            },
            textStyle = TextStyle(fontSize = 14.sp),
            readOnly = true,
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    keyboardController?.hide()
                },
        )
    }
}