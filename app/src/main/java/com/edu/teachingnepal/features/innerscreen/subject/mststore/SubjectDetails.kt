package com.edu.teachingnepal.features.innerscreen.subject.mststore

import android.os.Parcelable
import androidx.compose.ui.graphics.painter.Painter
import kotlinx.android.parcel.Parcelize

// plugin id("kotlin-parcelize")
@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
class SubjectDetail(
    val topic: String,
    val description: String,
): Parcelable