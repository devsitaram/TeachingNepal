package com.edu.teachingnepal.features.innerscreen.home

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeScreenItems(val route: String){
    object MainHomeScreen: HomeScreenItems("MainHomeViewScreen")
    object SearchScreen: HomeScreenItems("SearchScreen")
    object NotificationsScreen: HomeScreenItems("NotificationsScreen")
    object NoticesScreen: HomeScreenItems("NoticesScreen")
    object SettingScreen: HomeScreenItems("SettingScreen")
}

data class HomePageItemList(
    val icon: ImageVector,
    val title: String,
    val description: String,
    val color: Color
)