package com.housekeeping.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.housekeeping.model.entity.Order
import com.housekeeping.model.repository.OrderRepository
import com.housekeeping.model.request.OrderParam
import kotlinx.coroutines.launch

class OrderViewModel(
    private val repository: OrderRepository
) : ViewModel() {
    private val _orderListState = MutableLiveData<UiState<List<Order>>>()
    val orderListState: LiveData<UiState<List<Order>>> = _orderListState

    fun fetchOrders(userId: Int) {
        _orderListState.value = UiState.Loading
        viewModelScope.launch {
            val data = repository.getUserOrders(userId)
            _orderListState.value = if (data.isEmpty()) UiState.Empty else UiState.Success(data)
        }
    }

    fun createOrder(param: OrderParam, callback: (Result<Order>) -> Unit) {
        viewModelScope.launch {
            callback(repository.createOrder(param))
        }
    }
}
