package com.example.ap1.data

import com.example.ap1.network.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    // Existing login method
    suspend fun login(username: String, password: String): LoginResponse {
        val loginRequest = LoginRequest(username, password)
        return apiService.login(loginRequest)
    }

    // New method to get dashboard data
    suspend fun getDashboardData(keypass: String): DashboardResponse {
        return apiService.getDashboardData("dashboard/$keypass")
    }
}
