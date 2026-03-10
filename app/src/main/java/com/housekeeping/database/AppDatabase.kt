package com.housekeeping.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.housekeeping.database.dao.CartDao
import com.housekeeping.database.dao.OrderDao
import com.housekeeping.database.entity.CartEntity
import com.housekeeping.database.entity.OrderCacheEntity

@Database(entities = [CartEntity::class, OrderCacheEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
    abstract fun orderDao(): OrderDao
}
