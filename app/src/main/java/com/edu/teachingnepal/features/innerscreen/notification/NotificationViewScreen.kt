package com.edu.teachingnepal.features.innerscreen.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SpeakerPhone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.innerscreen.home.HomeScreenItems
import com.edu.teachingnepal.features.util.ui.ButtonDialogBox
import com.edu.teachingnepal.features.util.ui.TextView
import com.edu.teachingnepal.features.util.ui.TopAppBar

@Composable
fun NotificationViewScreen(navHomeController: NavHostController) {

    var showDialogBox by remember { mutableStateOf(true) }
    val onDismiss: () -> Unit = {
        showDialogBox = false
    }

    var showAlertDialog by remember { mutableStateOf(false) }
    val onClick: () -> Unit = {
        showAlertDialog = true
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(title = "Notifications", navController = navHomeController)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Notifications(onClick = onClick)
        }
    }

    if (showAlertDialog) {
        ButtonDialogBox(
            title = "Expired",
            text = "This announcement has been expired.",
            onDismiss = {
                showAlertDialog = false
            }
        )
    }

    if (showDialogBox) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Notification Premium Denied") },
            text = { Text(text = "Please Grant Notification Permission from App Settings.") },
            confirmButton = {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    TextButton(
                        onClick = {
                            onDismiss()
                        }
                    ) {
                        Text(text = "Dismiss")
                    }
                    Button(
                        modifier = Modifier.height(50.dp),
                        onClick = {
                            onDismiss()
                            navHomeController.navigate(HomeScreenItems.SettingScreen.route)
                            // navigate to setting page
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.purple_500)
                        )
                    ) {
                        TextView(text = "Go to Settings", style = TextStyle(), modifier = Modifier)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = ShapeDefaults.ExtraSmall
        )
    }
}

@Composable
fun Notifications(onClick: ()-> Unit = {}) {
    NotificationListItems(
        notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "A new teaching resource WRL Sample & Templates has been shared with you.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "A new teaching resource WRL Slides has been shares with you.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
    NotificationListItems(
        notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
        datetime = "27 Aug 2023 01:00 PM",
        onClick = { onClick() }
    )
}

@Composable
fun NotificationListItems(
    notifications: String,
    datetime: String,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 5.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.Top
    ) {
        Icon(imageVector = Icons.Default.SpeakerPhone, contentDescription = null)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, bottom = 10.dp)
        ) {
            TextView(
                text = notifications,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp
                ),
                modifier = Modifier
            )
            TextView(
                text = datetime,
                style = TextStyle(fontSize = 10.sp, color = Color.Gray),
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.2.dp)
            .padding(start = 15.dp, end = 15.dp)
    )
}

//@Composable
//fun NotificationViewScreens(navHomeController: NavHostController) {
//    val notificationList = mutableListOf<NotificationList>()
//    notificationList.add(NotificationList(
//        notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//    notificationList.add(NotificationList(
//        notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//    notificationList.add(NotificationList(
//        notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//    notificationList.add(NotificationList(
//        notifications = "You have a new announcement from Umesh Nepal. Please check it in your dashboard.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//    notificationList.add(NotificationList(
//        notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//    notificationList.add(NotificationList(
//        notifications = "You have a new announcement from Aadesh Tandhukar. Please check it in your dashboard.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//    notificationList.add(NotificationList(
//        notifications = "A new teaching resource WRL Sample & Templates has been shared with you.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//    notificationList.add(NotificationList(
//        notifications = "A new teaching resource WRL Sample & Templates has been shared with you.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//    notificationList.add(NotificationList(
//        notifications = "A new teaching resource WRL Slides has been shares with you.",
//        datetime = "27 Aug 2023 01:00 PM",
//    ))
//
//    var showDialogBox by remember { mutableStateOf(true) }
//    val onDismiss: () -> Unit = {
//        showDialogBox = false
//    }
//
//    var showAlertDialog by remember { mutableStateOf(false) }
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
//            LazyColumn{
//                items(notificationList){item->
//                    NotificationListItems(
//                        notifications = item.notifications,
//                        datetime = item.datetime,
//                        onClick = { onClick() }
//                    )
//                }
//            }
//        }
//    }
//    if (showAlertDialog) {
//        ButtonDialogBox(
//            title = "Expired",
//            text = "This announcement has been expired.",
//            onDismiss = {
//                showAlertDialog = false
//            }
//        )
//    }
//
//    if (showDialogBox) {
//        AlertDialog(
//            onDismissRequest = { onDismiss() },
//            title = { Text(text = "Notification Premium Denied") },
//            text = { Text(text = "Please Grant Notification Permission from App Settings.") },
//            confirmButton = {
//                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//                    TextButton(
//                        onClick = {
//                            onDismiss()
//                        }
//                    ) {
//                        Text(text = "Dismiss")
//                    }
//                    Button(
//                        modifier = Modifier.height(50.dp),
//                        onClick = {
//                            onDismiss()
//                            navHomeController.navigate(HomeScreenItems.SettingScreen.route)
//                            // navigate to setting page
//                        },
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = colorResource(id = R.color.purple_500)
//                        )
//                    ) {
//                        TextView(text = "Go to Settings", style = TextStyle(), modifier = Modifier)
//                    }
//                }
//            },
//            modifier = Modifier.fillMaxWidth(),
//            shape = ShapeDefaults.ExtraSmall
//        )
//    }
//}