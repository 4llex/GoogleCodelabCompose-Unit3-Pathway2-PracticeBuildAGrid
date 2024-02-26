package com.example.gridlistapp.data

import com.example.gridlistapp.R
import com.example.gridlistapp.model.CourseItemModel

class DataSource() {
    fun loadCourses() : List<CourseItemModel> {
        return listOf(
            CourseItemModel(R.drawable.architecture, R.string.architecture, 58),
            CourseItemModel(R.drawable.crafts, R.string.crafts, 121),
            CourseItemModel(R.drawable.business, R.string.business, 78),
            CourseItemModel(R.drawable.culinary, R.string.culinary, 118),
            CourseItemModel(R.drawable.design, R.string.design, 423),
            CourseItemModel(R.drawable.fashion, R.string.fashion, 92),
            CourseItemModel(R.drawable.film, R.string.film, 165),
            CourseItemModel(R.drawable.gaming, R.string.gaming, 164),
            CourseItemModel(R.drawable.drawing, R.string.drawing, 326),
            CourseItemModel(R.drawable.lifestyle, R.string.lifestyle, 305),
            CourseItemModel(R.drawable.music, R.string.music, 212),
            CourseItemModel(R.drawable.painting, R.string.painting, 172),
            CourseItemModel(R.drawable.photography, R.string.photography, 321),
            CourseItemModel(R.drawable.tech, R.string.tech, 118)
        )
    }
}