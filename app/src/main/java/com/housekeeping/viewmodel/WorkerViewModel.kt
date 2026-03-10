package com.housekeeping.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkerViewModel : ViewModel() {
    private val _incomeSummary = MutableLiveData("本月收入：¥0.00")
    val incomeSummary: LiveData<String> = _incomeSummary
}
