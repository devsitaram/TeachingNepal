package com.edu.teachingnepal.features.util.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.teachingnepal.R
import com.edu.teachingnepal.ui.theme.pink
import com.edu.teachingnepal.ui.theme.white

// normal text fields
@Composable
fun OutlineTextFieldView(
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
fun PasswordTextFieldView(
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


@Composable
fun TradingIconTextFieldView(
    value: String,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit,
    onSearch: () -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .shadow(5.dp)
            .border(1.dp, white),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                TextView(
                    text = "Search for answers",
                    style = TextStyle(fontSize = 14.sp, color = Color.DarkGray),
                    modifier = Modifier
                )
            },
            trailingIcon = {
                if (value.isNotEmpty()) {
                    IconButton(onClick = { onClear() }) {
                        Icon(
                            imageVector = Icons.Default.Cancel,
                            contentDescription = null,
                            tint = Color.LightGray,
                        )
                    }
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.DarkGray,
                cursorColor = Color.White,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.White,
                errorCursorColor = Color.White,
                disabledIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.width(280.dp)
        )
        IconButton(
            onClick = { onSearch() },
            modifier = Modifier
                .background(pink)
                .height(55.dp)
                .padding(1.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownOutlineTextFieldView(
    itemsList: Array<String>,
    expanded: Boolean,
    selectedItem: String,
    onExpandedChange: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit = {},
    onDismissRequest: () -> Unit = {},
    modifier: Modifier
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
            modifier = modifier
                .clickable {
                    keyboardController?.hide()
                },
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownNormalTextFieldView(
    itemsList: Array<String>,
    expanded: Boolean,
    selectedItem: String,
    onExpandedChange: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit = {},
    onDismissRequest: () -> Unit = {},
    label: String,
    imageVector: () -> Unit,
    modifier: Modifier
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
            label = {
                TextView(
                    text = label,
                    style = TextStyle(fontSize = 10.sp),
                    modifier = Modifier
                )
            },
            leadingIcon = { imageVector() },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = localExpanded)
            },
            textStyle = TextStyle(fontSize = 14.sp),
            readOnly = true,
            singleLine = true,
            maxLines = 1,
            modifier = modifier
                .clickable {
                    keyboardController?.hide()
                },
        )
    }
}