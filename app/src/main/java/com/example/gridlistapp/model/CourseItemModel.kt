package com.example.gridlistapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseItemModel(
    @DrawableRes val imageResourceId: Int,
    @StringRes val nameResourceId: Int,
    val numberOfCourses: Int
) {
}