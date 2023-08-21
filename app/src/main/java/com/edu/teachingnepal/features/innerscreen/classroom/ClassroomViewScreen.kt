package com.edu.teachingnepal.features.innerscreen.classroom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.features.util.ui.ButtonAppBar
import com.edu.teachingnepal.features.util.ui.DropDownNormalTextFieldView

@Composable
fun ClassroomViewScreen(navController: NavHostController) {

    val listOfAllSubject = arrayOf(
        "Grade 12",
        "Grade 11",
        "Grade 10",
        "Grade 9",
        "Grade 8",
        "Grade 7",
        "Grade 6",
        "Grade 5",
        "Grade 4"
    )
    val listOfSubject = arrayOf("Subjects", "Assets", "Levels")
    // state of the menu
    var expandedAllSubject by remember { mutableStateOf(false) }
    var expandedSubject by remember { mutableStateOf(false) }
    // remember the selected item
    var selectedAllSubject by remember { mutableStateOf(listOfAllSubject[0]) }
    var selectedSubject by remember { mutableStateOf(listOfSubject[0]) }

    val onClear: () -> Unit = {
        selectedAllSubject = listOfAllSubject[0]
        selectedSubject = listOfSubject[0]
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonAppBar(navController)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // dropdown text fields
            DropDownNormalTextFieldView(
                itemsList = listOfAllSubject,
                expanded = expandedAllSubject,
                selectedItem = selectedAllSubject,
                onExpandedChange = { expandedAllSubject = !expandedAllSubject },
                onValueChange = { selectedAllSubject = it },
                onDismissRequest = { expandedAllSubject = false },
                label = "Subject",
                imageVector = { },
                modifier = Modifier.width(180.dp)
            )

            // dropdown text fields
            DropDownNormalTextFieldView(
                itemsList = listOfAllSubject,
                expanded = expandedAllSubject,
                selectedItem = selectedAllSubject,
                onExpandedChange = { expandedAllSubject = !expandedAllSubject },
                onValueChange = { selectedAllSubject = it },
                onDismissRequest = { expandedAllSubject = false },
                label = "Class",
                imageVector = {},
                modifier = Modifier.width(180.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(text = "Hello")
        }
    }
}