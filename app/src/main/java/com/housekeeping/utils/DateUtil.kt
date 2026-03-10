package com.housekeeping.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtil {
    private val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    fun format(timestamp: Long): String = format.format(Date(timestamp))
}
