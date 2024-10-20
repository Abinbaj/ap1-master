package com.example.ap1.data

import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "keypass") val keypass: String

)
