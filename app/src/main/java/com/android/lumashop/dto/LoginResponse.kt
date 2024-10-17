package com.android.lumashop.dto

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val accessToken: String?,
    val userId: String?,
    val email: String?
)
