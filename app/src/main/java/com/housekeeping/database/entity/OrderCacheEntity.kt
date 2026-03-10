package com.housekeeping.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order_cache")
data class OrderCacheEntity(
    @PrimaryKey val id: Int,
    val userId: Int,
    val serviceId: Int,
    val status: Int,
    val serviceTime: Long,
    val address: String,
    val amount: Double,
    val remark: String?
)
