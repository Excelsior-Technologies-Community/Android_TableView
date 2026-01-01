package com.ext.tableview.model

import android.graphics.Color

data class TableStyle(
    val cellTextSize: Float = 14f,
    val cellPadding: Int = 16,
    val headerBackground: Int = Color.LTGRAY,
    val dividerColor: Int = Color.TRANSPARENT
)
