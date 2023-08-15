package com.edu.teachingnepal.features.innerscreen.main

import com.edu.teachingnepal.R

open class ScreenListItem(var icon: Int, val route: String) {
    object Home: ScreenListItem(R.drawable.ic_home,"Home")
    object Subject: ScreenListItem(R.drawable.ic_subject,"Subject")
    object Classroom: ScreenListItem(R.drawable.ic_classroom,"Classroom")
    object APTutor: ScreenListItem(R.drawable.ic_message,"AP Tutor")
    object More: ScreenListItem(R.drawable.ic_more,"More")
}
