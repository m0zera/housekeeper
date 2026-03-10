package com.housekeeping.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _banner = MutableLiveData(listOf("新人立减20元", "下单返积分", "会员套餐优惠"))
    val banner: LiveData<List<String>> = _banner
}
