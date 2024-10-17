package com.android.lumashop.dto

data class APIResponse<T>(
    val status: String,
    val message: String,
    val data: T?,
    val errors: List<String>?
)
