package com.housekeeping.model.entity

/**
 * 全局统一响应模型
 */
data class BaseResponse<T>(
    val code: Int,
    val msg: String,
    val data: T?,
    val timestamp: Long
) {
    fun isSuccess(): Boolean = code == 200
}
