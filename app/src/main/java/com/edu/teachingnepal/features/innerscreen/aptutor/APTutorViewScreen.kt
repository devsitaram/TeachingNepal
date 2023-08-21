package com.edu.teachingnepal.features.innerscreen.aptutor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.features.util.ui.AppBarView
import com.edu.teachingnepal.features.util.ui.TextButtonWithImageIcon
import com.edu.teachingnepal.features.util.ui.TextView
import com.edu.teachingnepal.features.util.ui.TradingIconTextFieldView
import com.edu.teachingnepal.ui.theme.pink

@Composable
fun APTutorViewScreen(navController: NavHostController) {

    var values by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBarView()
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(pink),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(), horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    TextView(
                        text = "We're online and ready to help",
                        style = TextStyle(
                            fontSize = 33.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            lineHeight = 50.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 40.dp)
                    )
                    TextView(
                        text = "Search Our knowledge base or start a chat",
                        style = TextStyle(
                            fontSize = 17.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                            lineHeight = 30.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(25.dp)
                    )
                    Spacer(modifier = Modifier.padding(bottom = 15.dp))
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                Card(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(top = 280.dp, start = 15.dp, end = 15.dp),
                ) {
                    TradingIconTextFieldView(
                        value = values,
                        onValueChange = { values = it },
                        onClear = { values = "" },
                        onSearch = { }
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth().shadow(2.dp)
                        .padding(top = 355.dp, start = 15.dp, end = 15.dp),
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(20.dp)
                            .height(55.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = null,
                                tint = Color.White
                            )
                            TextView(
                                text = "New Conversation",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                ),
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}