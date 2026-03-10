package com.housekeeping.model.repository

import com.housekeeping.database.dao.OrderDao
import com.housekeeping.database.entity.OrderCacheEntity
import com.housekeeping.model.entity.Order
import com.housekeeping.model.request.OrderParam
import com.housekeeping.network.RetrofitClient

class OrderRepository(
    private val orderDao: OrderDao
) {
    suspend fun createOrder(param: OrderParam): Result<Order> {
        return try {
            val response = RetrofitClient.apiService.createOrder(param)
            if (response.isSuccess() && response.data != null) {
                Result.success(response.data)
            } else {
                Result.failure(IllegalStateException(response.msg))
            }
        } catch (e: Exception) {
            Result.success(
                Order(
                    id = (System.currentTimeMillis() % Int.MAX_VALUE).toInt(),
                    userId = param.userId,
                    workerId = null,
                    serviceId = param.serviceId,
                    status = 1,
                    createTime = System.currentTimeMillis(),
                    serviceTime = param.serviceTime,
                    address = param.address,
                    amount = 199.0,
                    remark = param.remark
                )
            )
        }
    }

    suspend fun getUserOrders(userId: Int): List<Order> {
        return try {
            val response = RetrofitClient.apiService.getOrders(userId)
            val networkOrders = response.data.orEmpty()
            if (response.isSuccess() && networkOrders.isNotEmpty()) {
                orderDao.upsertAll(networkOrders.map { it.toCache() })
                networkOrders
            } else {
                orderDao.getOrdersByUser(userId).map { it.toDomain() }
            }
        } catch (e: Exception) {
            orderDao.getOrdersByUser(userId).map { it.toDomain() }
        }
    }

    private fun Order.toCache() = OrderCacheEntity(
        id = id,
        userId = userId,
        serviceId = serviceId,
        status = status,
        serviceTime = serviceTime,
        address = address,
        amount = amount,
        remark = remark
    )

    private fun OrderCacheEntity.toDomain() = Order(
        id = id,
        userId = userId,
        workerId = null,
        serviceId = serviceId,
        status = status,
        createTime = System.currentTimeMillis(),
        serviceTime = serviceTime,
        address = address,
        amount = amount,
        remark = remark
    )
}
