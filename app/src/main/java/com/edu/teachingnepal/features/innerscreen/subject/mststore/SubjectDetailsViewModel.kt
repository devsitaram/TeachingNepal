package com.edu.teachingnepal.features.innerscreen.subject.mststore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SubjectDetailsViewModel : ViewModel() {
    var subjectDetails by mutableStateOf<SubjectDetail?>(null)
        private set
    fun addSubjectDetails(newSubjectDetails:SubjectDetail){
        subjectDetails = newSubjectDetails
    }
}