package com.housekeeping.network

import com.housekeeping.model.entity.BaseResponse
import com.housekeeping.model.entity.Order
import com.housekeeping.model.entity.ServiceItem
import com.housekeeping.model.entity.User
import com.housekeeping.model.request.LoginParam
import com.housekeeping.model.request.OrderParam
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body param: LoginParam): BaseResponse<User>

    @GET("services")
    suspend fun getServiceList(@Query("keyword") keyword: String?): BaseResponse<List<ServiceItem>>

    @POST("orders")
    suspend fun createOrder(@Body param: OrderParam): BaseResponse<Order>

    @GET("orders")
    suspend fun getOrders(@Query("userId") userId: Int): BaseResponse<List<Order>>
}
