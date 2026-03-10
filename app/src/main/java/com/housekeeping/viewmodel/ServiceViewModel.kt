package com.housekeeping.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.housekeeping.model.entity.ServiceItem
import com.housekeeping.model.repository.ServiceRepository
import kotlinx.coroutines.launch

class ServiceViewModel(
    private val repository: ServiceRepository
) : ViewModel() {
    private val _serviceState = MutableLiveData<UiState<List<ServiceItem>>>()
    val serviceState: LiveData<UiState<List<ServiceItem>>> = _serviceState

    fun loadServices(keyword: String? = null) {
        _serviceState.value = UiState.Loading
        viewModelScope.launch {
            val list = repository.getServiceList(keyword)
            _serviceState.value = if (list.isEmpty()) UiState.Empty else UiState.Success(list)
        }
    }
}
