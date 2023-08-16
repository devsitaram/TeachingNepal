package com.edu.teachingnepal.features.innerscreen.subject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Filter
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.innerscreen.home.ButtonAppBar
import com.edu.teachingnepal.features.util.ui.DropDownTextFieldView
import com.edu.teachingnepal.features.util.ui.IconViewPainter
import com.edu.teachingnepal.features.util.ui.MaterialButton
import com.edu.teachingnepal.features.util.ui.TextView
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SubjectViewScreen(navController: NavHostController) {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    val onButtonClick: () -> Unit = {
        scope.launch {
            if (scaffoldState.bottomSheetState.isExpanded) {
                scaffoldState.bottomSheetState.collapse()
            } else {
                scaffoldState.bottomSheetState.expand()
            }
        }
    }

    Column(Modifier.fillMaxWidth()) {
        // top bar
        ButtonAppBar(navController)

        TabScreen()
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = 0.dp,
            sheetShape = ShapeDefaults.ExtraLarge,
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally),
            sheetContent = {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ) {
                    ButtonSheetField(onClickAction = { onButtonClick() })
                }
            }
        ) { innerPadding ->
            // this is the screen
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Action button
                Button(onClick = { onButtonClick() }) {
                    Icon(
                        imageVector = Icons.Default.FilterAlt,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.padding(3.dp)
                        )
                    Text(text = "Filters", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun ButtonSheetField(onClickAction: () -> Unit = {}) {
    // items list
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
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(top = 30.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onClickAction() }) {
                IconViewPainter(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    modifier = Modifier
                )
            }
            TextView(
                text = "Filter By",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(start = 5.dp)
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                TextView(
                    text = "Reset Filters",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.clickable { onClear() }
                )
            }
        }

        Column(
            modifier = Modifier
                .height(250.dp)
                .padding(bottom = 60.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // dropdown text fields
            DropDownTextFieldView(
                itemsList = listOfAllSubject,
                expanded = expandedAllSubject,
                selectedItem = selectedAllSubject,
                onExpandedChange = { expandedAllSubject = !expandedAllSubject },
                onValueChange = { selectedAllSubject = it }
            ) { expandedAllSubject = false }

            DropDownTextFieldView(
                itemsList = listOfSubject,
                expanded = expandedSubject,
                selectedItem = selectedSubject,
                onExpandedChange = { expandedSubject = !expandedSubject },
                onValueChange = { selectedSubject = it }
            ) { expandedSubject = false }

            // apply button
            MaterialButton(
                text = "Apply",
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { onClickAction() }
            )
        }
    }
}

@Composable
fun SnackBarButtonScreen() {
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        floatingActionButton = {
            var clickCount by remember { mutableIntStateOf(0) }
            ExtendedFloatingActionButton(
                onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar(
                            "SnackBar # ${++clickCount}"
                        )
                    }
                }
            ) { Text("Show snackBar") }
        },
        content = { innerPadding ->
            Text(
                text = "Body content",
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }
    )
}

@Composable
fun TabScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("My Library", "MST Store")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> HomeScreen()
            1 -> AboutScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Home")
    }
}

@Composable
fun AboutScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "About")
    }
}

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        androidx.compose.material3.Text(text = "Setting")
    }
}