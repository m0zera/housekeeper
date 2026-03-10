package com.housekeeping.model.request

/** 登录参数 */
data class LoginParam(
    val phone: String,
    val password: String
)

/** 提交订单参数 */
data class OrderParam(
    val userId: Int,
    val serviceId: Int,
    val serviceTime: Long,
    val address: String,
    val remark: String?
)
