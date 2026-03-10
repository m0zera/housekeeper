package com.housekeeping.utils

import android.content.Context
import android.net.ConnectivityManager

object NetWorkUtil {
    fun isConnected(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        return manager?.activeNetworkInfo?.isConnected == true
    }
}
