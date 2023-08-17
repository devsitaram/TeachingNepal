package com.edu.teachingnepal.features.innerscreen.subject

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.teachingnepal.R
import com.edu.teachingnepal.features.util.ui.ContentCardView
import com.edu.teachingnepal.features.util.ui.DropDownTextFieldView
import com.edu.teachingnepal.features.util.ui.IconViewPainter
import com.edu.teachingnepal.features.util.ui.MaterialButton
import com.edu.teachingnepal.features.util.ui.TextView
import com.edu.teachingnepal.ui.theme.skyBlue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MSTStoreViewScreen() {

    val context = LocalContext.current
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

    Column(modifier = Modifier.fillMaxWidth()) {
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
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
            ) {
                // this is the screen
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, bottom = 55.dp)
                        .verticalScroll(rememberScrollState()),
                ) {
                    // contents
                    TextView(
                        text = "Packages",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(top = 20.dp, bottom = 15.dp)
                    )
                    // card view details
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 10: Economic",
                        description = "Grade 10 syllabus: Economics"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Non-Science",
                        description = "Grade 11 syllabus: Nepali, English, Social Studies, Mathematics, Business Studies, Accounts, Economics, Computer Science."
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Science",
                        description = "Grade 11 syllabus: Nepali, English, Social Studies, Mathematics, Physics Chemistry, Biology, Computer Science."
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Biology",
                        description = "Grade 11 syllabus: Biology"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Business Studies",
                        description = "Grade 11 syllabus: Business Studies"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Chemistry",
                        description = "Grade 11 syllabus: Chemistry"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Computer Sciences",
                        description = "Grade 11 syllabus: Computer Science"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Economic",
                        description = "Grade 11 syllabus: Economics"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: English",
                        description = "Grade 11 syllabus: English"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Mathematics",
                        description = "Grade 11 syllabus: Mathematics"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Nepali",
                        description = "Grade 11 syllabus: Nepali"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Physics",
                        description = "Grade 11 syllabus: Physics"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Principal of Accounting",
                        description = "Grade 11 syllabus: Principal of Accounting"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 11: Social Studies and Life Skill Education",
                        description = "Grade 11 syllabus: Social Studies and Life Skill Education"
                    )

                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 12: Biology",
                        description = "Grade 12 syllabus: Biology"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 12: Chemistry",
                        description = "Grade 12 syllabus: Chemistry"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 12: Economic",
                        description = "Grade 12 syllabus: Economics"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 12: English",
                        description = "Grade 12 syllabus: English"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 12: Mathematics",
                        description = "Grade 12 syllabus: Mathematics"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 12: Nepali",
                        description = "Grade 12 syllabus: Nepali"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 12: Physics",
                        description = "Grade 12 syllabus: Physics"
                    )
                    ContentCardView(
                        painter = painterResource(id = R.mipmap.img_10_economic),
                        topic = "Grade 12: Principal of Accounting",
                        description = "Grade 12 syllabus: Principal of Accounting"
                    )

                }

                // filter button parent box
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 70.dp)
                        .background(Color.Transparent),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    // Action button
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent), contentAlignment = Alignment.BottomEnd
                    ) {
                        Button(
                            onClick = { onButtonClick() },
                            modifier = Modifier.padding(end = 10.dp)
                        ) {
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

//Button(onClick = {
//    Toast.makeText(context, "Hello doxt", Toast.LENGTH_SHORT).show()
//}) {
//    Text(text = "Ok")
//}