package com.housekeeping.model.repository

import com.housekeeping.model.entity.ServiceItem
import com.housekeeping.network.RetrofitClient

class ServiceRepository {
    suspend fun getServiceList(keyword: String?): List<ServiceItem> {
        return try {
            val response = RetrofitClient.apiService.getServiceList(keyword)
            if (response.isSuccess() && !response.data.isNullOrEmpty()) {
                response.data
            } else {
                mockServiceList(keyword)
            }
        } catch (e: Exception) {
            mockServiceList(keyword)
        }
    }

    private fun mockServiceList(keyword: String?): List<ServiceItem> {
        val all = listOf(
            ServiceItem(1, "深度保洁", 1, 168.0, null, "全屋深度清洁，含厨房与卫生间", 180),
            ServiceItem(2, "金牌月嫂", 2, 498.0, null, "产后护理与新生儿照护", 480),
            ServiceItem(3, "育儿陪护", 3, 258.0, null, "婴幼儿照看与早教互动", 240)
        )
        return if (keyword.isNullOrBlank()) all else all.filter { it.name.contains(keyword) }
    }
}
