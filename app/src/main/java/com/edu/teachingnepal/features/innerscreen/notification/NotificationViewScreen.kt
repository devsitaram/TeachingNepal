//package com.edu.teachingnepal.features.innerscreen.notification
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Divider
//import androidx.compose.material.Icon
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.SpeakerPhone
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import com.edu.teachingnepal.features.util.ui.ButtonDialogBox
//import com.edu.teachingnepal.features.util.ui.TextView
//import com.edu.teachingnepal.features.util.ui.TopAppBar
//
//@Composable
//fun NotificationViewScreen(navHomeController: NavHostController) {
//
//    var showAlertDialog by remember { mutableStateOf(false) }
//
//    val onClick: () -> Unit = {
//        showAlertDialog = true
//    }
//
//    Column(modifier = Modifier.fillMaxWidth()) {
//        TopAppBar(title = "Notifications", navController = navHomeController)
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 15.dp, end = 15.dp)
//                .verticalScroll(rememberScrollState()),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "A new teaching resource WRL Sample & Templates has been shared with you.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "A new teaching resource WRL Slides has been shares with you.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//            NotificationListItems(
//                imageVector = Icons.Default.SpeakerPhone,
//                notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
//                datetime = "27 Aug 2023 01:00 PM",
//                onClick = { onClick() }
//            )
//        }
//    }
//    if (showAlertDialog){
//        ButtonDialogBox(
//            title = "Expired",
//            text = "This announcement has been expired.",
//            onDismiss = {
//                showAlertDialog = false
//            }
//        )
//    }
//}
//
//@Composable
//fun NotificationListItems(
//    imageVector: ImageVector,
//    notifications: String,
//    datetime: String,
//    onClick: () -> Unit = {}
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 20.dp, bottom = 5.dp)
//            .clickable {
//                onClick()
//            },
//        verticalAlignment = Alignment.Top
//    ) {
//        Icon(imageVector = imageVector, contentDescription = null)
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 10.dp, bottom = 10.dp)
//        ) {
//            TextView(
//                text = notifications,
//                style = TextStyle(
//                    fontSize = 13.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    lineHeight = 20.sp
//                ),
//                modifier = Modifier
//            )
//            TextView(
//                text = datetime,
//                style = TextStyle(fontSize = 10.sp, color = Color.Gray),
//                modifier = Modifier.padding(top = 5.dp)
//            )
//        }
//    }
//    Divider(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(0.2.dp)
//            .padding(start = 15.dp, end = 15.dp)
//    )
//}