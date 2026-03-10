package com.housekeeping.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.housekeeping.database.entity.OrderCacheEntity

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<OrderCacheEntity>)

    @Query("SELECT * FROM order_cache WHERE userId = :userId")
    suspend fun getOrdersByUser(userId: Int): List<OrderCacheEntity>
}
