package com.edu.teachingnepal.features.util.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.teachingnepal.R

// normal text fields
@Composable
fun OutlineTextFields(value: String, onValueChange: (String) -> Unit = {}, placeholder: String, isEmpty: Boolean, isError: Boolean) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { InputText(text = placeholder, color = Color.Gray) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        isError = (isEmpty || isError),
        modifier = Modifier.fillMaxWidth()
    )
    if (isEmpty){
        SmallText(text = "The field is required", color = Color.Red)
    }
    if(isError){
        SmallText(text = "Enter the valid email address", color = Color.Red)
    }
}

// password text fields
@Composable
fun PasswordTextField(value: String, onValueChange: (String) -> Unit = {}, placeholder: String, isEmpty: Boolean) {
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
        placeholder = { InputText(text = placeholder, color = Color.Gray) },
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