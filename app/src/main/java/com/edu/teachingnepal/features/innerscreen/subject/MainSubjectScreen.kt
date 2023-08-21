package com.edu.teachingnepal.features.innerscreen.subject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.edu.teachingnepal.features.innerscreen.subject.mststore.SubjectDetailsViewModel
import com.edu.teachingnepal.features.util.ui.ButtonAppBar

@Composable
fun SubjectViewScreen(
    navController: NavHostController,
    subjectDetailsViewModel: SubjectDetailsViewModel,
) {

    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("MST Store", "My Library")

    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // top bar
        ButtonAppBar(navController)
        // tab screen
        Column(modifier = Modifier) {
            TabRow(
                selectedTabIndex = tabIndex,
                containerColor = Color.White
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(text = { Text(title) },
                        selected = tabIndex == index,
                        onClick = { tabIndex = index }
                    )
                }
            }
            when (tabIndex) {
                0 -> MSTStoreViewScreen(navController, subjectDetailsViewModel) // MSTStoreViewScreen
                1 -> MyLibraryViewScreen()
            }
        }
    }
}

//@Composable
//fun TabRowView(navController: NavHostController) {
////    var tabIndex by remember { mutableIntStateOf(0) }
////    val tabs = listOf("My Library", "MST Store")
////
////    Column(modifier = Modifier) {
////        TabRow(
////            selectedTabIndex = tabIndex,
////            containerColor = Color.White
////        ) {
////            tabs.forEachIndexed { index, title ->
////                Tab(text = { Text(title) },
////                    selected = tabIndex == index,
////                    onClick = { tabIndex = index }
////                )
////            }
////        }
////        when (tabIndex) {
////            0 -> MyLibraryViewScreen()
////            1 -> MSTStoreViewScreen(navController)
////        }
////    }
//}