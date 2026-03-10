package com.housekeeping.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartEntity(
    @PrimaryKey val serviceId: Int,
    val name: String,
    val price: Double,
    val count: Int = 1,
    val imgUrl: String?
)
