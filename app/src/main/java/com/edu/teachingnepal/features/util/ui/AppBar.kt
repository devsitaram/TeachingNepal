package com.edu.teachingnepal.features.util.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.innerscreen.main.MainScreenItems
import com.edu.teachingnepal.ui.theme.pink
import com.edu.teachingnepal.ui.theme.skyBlue
import com.edu.teachingnepal.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String, navController: NavHostController) {
    TopAppBar(
        title = {
            TextView(
                text = title,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigateUp()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .shadow(2.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonAppBar() {
    TopAppBar(
        title = { Text(text = "") },
        navigationIcon = {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .width(IntrinsicSize.Max),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageViewPainter(
                    painterImage = painterResource(id = R.mipmap.img_islington),
                    modifier = Modifier.size(40.dp)
                )
                IconButton(
                    onClick = {
                        // onclick action
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonAppBar(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "") },
        navigationIcon = {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
                    .padding(top = 5.dp)
                    .width(IntrinsicSize.Max),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageViewPainter(
                    painterImage = painterResource(id = R.mipmap.img_islington),
                    modifier = Modifier.size(40.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    // search icon
                    IconButton(
                        onClick = {
                            navController.navigate(MainScreenItems.SearchScreen.route)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            tint = Color.Gray,
                        )
                    }
                    // notification icon
                    IconButton(onClick = {}) {
                        BottomNavigationItem(
                            icon = {
                                BadgedBox(
                                    badge = {
                                        Badge(backgroundColor = pink, contentColor = white) {
                                            TextView(
                                                text = "3",
                                                style = TextStyle(
                                                    color = white,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Normal
                                                ),
                                                modifier = Modifier
                                            )
                                        }
                                    }
                                ) {
                                    Icon(
                                        Icons.Filled.Notifications,
                                        contentDescription = "Notification"
                                    )
                                }
                            },
                            selected = false,
                            onClick = { navController.navigate(MainScreenItems.NotificationsScreen.route) },
                            modifier = Modifier,
                        )
                    }
                }
            }
        },
        modifier = Modifier
            .shadow(5.dp)
            .height(57.dp)
            .fillMaxWidth(),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView() {
    TopAppBar(
        title = { Text(text = "") },
        navigationIcon = {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
                    .padding(top = 5.dp)
                    .width(IntrinsicSize.Max),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageViewPainter(
                    painterImage = painterResource(id = R.mipmap.img_islington),
                    modifier = Modifier.size(40.dp)
                )
                // google search
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    IconButton(
                        onClick = {
//                            navController.navigate(MainScreenItems.SearchScreen.route)
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            tint = skyBlue,
                        )
                    }
                }
            }
        },
        modifier = Modifier
            .shadow(5.dp)
            .height(57.dp)
            .fillMaxWidth(),
    )
}