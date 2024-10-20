package com.example.ap1.network

import com.example.ap1.data.DashboardResponse
import com.example.ap1.data.Exercises
import com.example.ap1.data.LoginRequest
import com.example.ap1.data.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiService {
    @POST("/footscray/auth")
    suspend fun login(@Body loginRequest: LoginRequest ): LoginResponse

    @GET
    suspend fun getDashboardData(@Url url:String): DashboardResponse


}