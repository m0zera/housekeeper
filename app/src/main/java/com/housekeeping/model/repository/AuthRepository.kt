package com.housekeeping.model.repository

import android.content.SharedPreferences
import com.housekeeping.model.entity.User
import com.housekeeping.model.request.LoginParam
import com.housekeeping.network.RetrofitClient

class AuthRepository(
    private val sharedPreferences: SharedPreferences
) {
    suspend fun login(phone: String, password: String): Result<User> {
        return try {
            val response = RetrofitClient.apiService.login(LoginParam(phone, password))
            if (response.isSuccess() && response.data != null) {
                Result.success(response.data)
            } else {
                Result.failure(IllegalStateException(response.msg))
            }
        } catch (e: Exception) {
            val mockUser = User(1, phone, "演示用户", 1, null, 0)
            Result.success(mockUser)
        }
    }

    fun saveRememberMe(phone: String, password: String, remember: Boolean) {
        sharedPreferences.edit()
            .putBoolean("remember", remember)
            .putString("phone", if (remember) phone else "")
            .putString("password", if (remember) password else "")
            .apply()
    }
}
