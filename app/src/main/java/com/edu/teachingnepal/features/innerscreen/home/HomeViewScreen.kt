package com.edu.teachingnepal.features.innerscreen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.innerscreen.main.MainScreenItems
import com.edu.teachingnepal.features.innerscreen.notification.NotificationViewScreen
import com.edu.teachingnepal.features.innerscreen.search.SearchViewScreen
import com.edu.teachingnepal.features.util.ui.ImageViewPainter
import com.edu.teachingnepal.features.util.ui.TextView
import com.edu.teachingnepal.features.util.ui.CardViewMultiTask
import com.edu.teachingnepal.features.util.ui.CardViewSingleTask
import com.edu.teachingnepal.ui.theme.green
import com.edu.teachingnepal.ui.theme.orange
import com.edu.teachingnepal.ui.theme.pink
import com.edu.teachingnepal.ui.theme.skyBlue
import com.edu.teachingnepal.ui.theme.white
import com.edu.teachingnepal.ui.theme.yellow
import java.util.Locale

@Composable
fun HomeViewScreen(navController: NavHostController) {
    val name = "Sita Ram Thing,"
    val formattedText = getTextFormatted(name) // text convert into bold and upper case
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonAppBar(navController)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Welcome ")
                    append(formattedText)
                    append(" what would you like to do today?")
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(top = 25.dp, bottom = 20.dp)
            )
            CardViewSingleTask(
                imageVector = Icons.Default.ContentCopy,
                text = "Task List",
                color = yellow,
                onClick = {}
            )
            CardViewMultiTask(
                icon = Icons.Default.LiveTv,
                title = "Learn/Review",
                description = "Click here if you want to learn something new, or revise something that you have already learned",
                color = skyBlue
            )
            CardViewMultiTask(
                icon = Icons.Default.Person,
                title = "Get Answers",
                description = "Click here if you need to us to help you solve a question or explain a particular concept to you",
                color = pink
            )
            CardViewMultiTask(
                icon = Icons.Default.Computer,
                title = "Test Yourself",
                description = "Click here to assess how good you are, and identify areas of weakness so that you can directly work on those areas",
                color = green
            )
            CardViewMultiTask(
                icon = Icons.Default.Message,
                title = "Socialise",
                description = "Click here to socialise with members of your community, including entering live video and text-chat sessions",
                color = orange
            )
            CardViewMultiTask(
                icon = Icons.Default.EditNote,
                title = "Get & Sumbit Assignment",
                description = "Click here to get and sumbit work that your teachers have assigned to you",
                color = yellow
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


//@Composable
//fun MainHomeViewScreen() {
////    val contentList = mutableListOf<HomePageItemList>()
////    contentList.add(
////        HomePageItemList(
////            icon = Icons.Default.LiveTv,
////            title = "Learn/Review",
////            description = "Click here if you want to learn something new, or revise something that you have already learned",
////            color = skyBlue
////        )
////    )
////    contentList.add(
////        HomePageItemList(
////            icon = Icons.Default.Person,
////            title = "Get Answers",
////            description = "Click here if you need to us to help you solve a question or explain a particular concept to you",
////            color = pink
////        )
////    )
////    contentList.add(
////        HomePageItemList(
////            icon = Icons.Default.Computer,
////            title = "Test Yourself",
////            description = "Click here to assess how good you are, and identify areas of weakness so that you can directly work on those areas",
////            color = green
////        )
////    )
////    contentList.add(
////        HomePageItemList(
////            icon = Icons.Default.Message,
////            title = "Socialise",
////            description = "Click here to socialise with members of your community, including entering live video and text-chat sessions",
////            color = orange
////        )
////    )
////    contentList.add(
////        HomePageItemList(
////            icon = Icons.Default.Copyright,
////            title = "Get & Sumbit Assignment",
////            description = "Click here to get and sumbit work that your teachers have assigned to you",
////            color = yellow
////        )
////    )
//
//    val name = "Sita Ram Thing,"
//    val formattedText = getTextFormatted(name) // text convert into bold and upper case
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        ButtonAppBar()
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .verticalScroll(rememberScrollState())
//                .padding(start = 20.dp, end = 20.dp)
//        ) {
//            Text(
//                text = buildAnnotatedString {
//                    append("Welcome ")
//                    append(formattedText)
//                    append(" what would you like to do today?")
//                },
//                style = TextStyle(
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Normal,
//                    lineHeight = 20.sp,
//                    color = Color.Black
//                ),
//                modifier = Modifier.padding(top = 25.dp, bottom = 20.dp)
//            )
////            LazyColumn {
////                items(contentList) { item -> // Use 'items' for better performance
////                    CardViewMultiTask(
////                        icon = item.icon,
////                        title = item.title,
////                        description = item.description,
////                        color = item.color
////                    )
////                }
////            }
//            Spacer(modifier = Modifier.height(20.dp))
//        }
//    }
//}

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

/**
 * @param name: String parameter
 * this function can be input latter can convert the upper case and bold
 */
@Composable
fun getTextFormatted(name: String): AnnotatedString {
    return buildAnnotatedString {
        val words = name.split(" ")

        words.forEachIndexed { index, word ->
            val fontWeight = FontWeight.Bold
            val upperCasedWord = word.uppercase(Locale.ROOT)

            withStyle(style = SpanStyle(fontWeight = fontWeight)) {
                append(upperCasedWord)
            }

            if (index < words.size - 1) {
                append(" ")
            }
        }
    }
}

@Preview
@Composable
fun BadgeBoxDemo() {
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Favorite"
                )
            },
            selected = false,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(
                        Icons.Filled.Notifications,
                        contentDescription = "Favorite"
                    )
                }

            },
            selected = false,
            onClick = {},
        )
    }
}

//val context = LocalContext.current
//val activity = (LocalContext.current as Activity)
//val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
//
//Column(
//modifier = Modifier.fillMaxSize(),
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    Text(text = "Home")
//    Button(onClick = {
//        // Save the preference to indicate that the user has viewed the outer screen
//        val editor = sharedPreferences.edit()
//        editor.putString("outer_screen", "")
//        editor.apply()
//        activity.isDestroyed
//    }) {
//        Text(text = "Log out")
//    }
//}