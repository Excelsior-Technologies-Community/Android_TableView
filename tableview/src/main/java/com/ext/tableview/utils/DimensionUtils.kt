package com.ext.tableview.utils

import android.content.res.Resources

object DimensionUtils {

    fun dp(value: Int): Int {
        return (value * Resources.getSystem().displayMetrics.density).toInt()
    }
}