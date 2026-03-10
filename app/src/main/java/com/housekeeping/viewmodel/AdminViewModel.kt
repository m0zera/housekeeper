package com.housekeeping.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdminViewModel : ViewModel() {
    private val _dashboard = MutableLiveData(mapOf("orderCount" to 0, "tradeAmount" to 0, "activeUser" to 0))
    val dashboard: LiveData<Map<String, Int>> = _dashboard
}
