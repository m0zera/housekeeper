package com.housekeeping.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.housekeeping.model.entity.User
import com.housekeeping.model.repository.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableLiveData<UiState<User>>()
    val loginState: LiveData<UiState<User>> = _loginState

    fun login(phone: String, password: String, remember: Boolean) {
        _loginState.value = UiState.Loading
        viewModelScope.launch {
            val result = repository.login(phone, password)
            result.onSuccess {
                repository.saveRememberMe(phone, password, remember)
                _loginState.value = UiState.Success(it)
            }.onFailure {
                _loginState.value = UiState.Error(it.message ?: "登录失败")
            }
        }
    }
}
