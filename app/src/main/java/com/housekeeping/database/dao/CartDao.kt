package com.housekeeping.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.housekeeping.database.entity.CartEntity

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: CartEntity)

    @Query("SELECT * FROM cart")
    suspend fun getAll(): List<CartEntity>

    @Query("DELETE FROM cart")
    suspend fun clear()
}
