package com.housekeeping.model.entity

/** 用户模型 */
data class User(
    val id: Int,
    val phone: String,
    val name: String,
    val role: Int,
    val avatar: String?,
    val realNameStatus: Int
)

/** 服务模型 */
data class ServiceItem(
    val id: Int,
    val name: String,
    val category: Int,
    val price: Double,
    val imgUrl: String?,
    val detail: String,
    val duration: Int
)

/** 订单模型 */
data class Order(
    val id: Int,
    val userId: Int,
    val workerId: Int?,
    val serviceId: Int,
    val status: Int,
    val createTime: Long,
    val serviceTime: Long,
    val address: String,
    val amount: Double,
    val remark: String?
)

/** 评价模型 */
data class Comment(
    val id: Int,
    val orderId: Int,
    val content: String?,
    val score: Int,
    val imgUrls: List<String>?,
    val fromUserId: Int,
    val toUserId: Int
)

/** 服务人员模型 */
data class Worker(
    val id: Int,
    val name: String,
    val skill: List<Int>,
    val certificate: List<String>?,
    val score: Double,
    val status: Int
)
