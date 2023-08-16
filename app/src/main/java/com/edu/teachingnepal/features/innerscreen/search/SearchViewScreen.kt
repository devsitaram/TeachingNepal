package com.edu.teachingnepal.features.innerscreen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.util.ui.TextView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchViewScreen(navController: NavHostController) {

    val items = remember {
        mutableStateListOf("Google", "YouTube", "Facebook", "Tiktok")
    }

    var text by remember { mutableStateOf("") }
    var activeIcon by remember { mutableStateOf(false) }
    var active by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            query = text,
            onQueryChange = { newText ->
                text = newText
                if (newText.isNotEmpty()) {
                    active = true
                    activeIcon = true
                }
            },
            onSearch = {
                if (!items.contains(text)) { // Check if text is not already in the list
                    items.add(0, text)
                }
                active = false // Set active on search
            },
            onActiveChange = { newActive -> active = newActive },
            placeholder = {
                TextView(
                    text = "Search for chapters, topic or IVy",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    ),
                    modifier = Modifier,
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.navigateUp()
                    }
                )
            },
            trailingIcon = {
                if (activeIcon && text.isNotEmpty()) {
                    Icon(
                        modifier = Modifier.size(20.dp).clickable {
                            if (text.isNotEmpty()) {
                                text = ""
                            } else {
                                active = false
                            }
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }
        ) {
            // content
            if (active) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    items.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Row(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .clickable {
                                        text = item
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier.padding(10.dp),
                                    imageVector = Icons.Default.History,
                                    contentDescription = "History Icon"
                                )
                                Text(text = item)
                            }
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(end = 10.dp),
                                horizontalArrangement = Arrangement.End
                            ) {
                                IconButton(onClick = { items.remove(item) }) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextView(text = text, style = TextStyle(), modifier = Modifier)
                }
            }

        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: @Composable() (() -> Unit)? = null,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    content: @Composable() (ColumnScope.() -> Unit),
) {
    val color = Color.White
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = placeholder,
            textStyle = MaterialTheme.typography.body1,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch()
                    keyboardController?.hide() // Hide the keyboard on search
                }
            ),
            readOnly = !enabled,
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onActiveChange(true) }, // Set search bar as active on click
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = color,
                cursorColor = Color.Gray,
                focusedIndicatorColor = color,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            )
        )
        content()
    }
}