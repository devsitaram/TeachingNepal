package com.edu.teachingnepal.features.innerscreen.main

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.innerscreen.aptutor.APTutorViewScreen
import com.edu.teachingnepal.features.innerscreen.classroom.ClassroomViewScreen
import com.edu.teachingnepal.features.innerscreen.home.HomeViewScreen
import com.edu.teachingnepal.features.innerscreen.more.MoreViewScreen
import com.edu.teachingnepal.features.innerscreen.subject.SubjectViewScreen

@Composable
fun MainViewScreen() {
    MainButtonNavigationViewScreen()
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "home") {
//        composable("home") {
//
//        }
//    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainButtonNavigationViewScreen() {
    val navController = rememberNavController()
    val pages = listOf(
        ScreenListItem.Home,
        ScreenListItem.Subject,
        ScreenListItem.Classroom,
        ScreenListItem.APTutor,
        ScreenListItem.More
    )
    Scaffold (
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                pages.forEach { screen ->
                    BottomNavigationItem(modifier = Modifier.background(color = Color.White),
                        icon = {
                            Icon(
                                painterResource(screen.icon),
                                contentDescription = null,
                                // Set the desired icon color
                                tint = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                                    colorResource(id = R.color.purple_700)
                                } else {
                                    Color.Gray
                                }
                            )
                        },
                        label = {
                            Text(
                                text = screen.route,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                color = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                                    colorResource(id = R.color.purple_500)
                                } else {
                                    Color.Gray
                                }
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // selecting the same item
                                launchSingleTop = true
                                // Restore state when selecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenListItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenListItem.Home.route) { HomeViewScreen() }
            composable(ScreenListItem.Subject.route) { SubjectViewScreen() }
            composable(ScreenListItem.Classroom.route) { ClassroomViewScreen() }
            composable(ScreenListItem.APTutor.route) { APTutorViewScreen() }
            composable(ScreenListItem.More.route) { MoreViewScreen() }
        }
    }
}
