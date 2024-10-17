package com.android.lumashop.api

import com.android.lumashop.dto.APIResponse
import com.android.lumashop.dto.LoginRequest
import com.android.lumashop.dto.LoginResponse
import com.android.lumashop.dto.RegisterRequest
import com.android.lumashop.dto.RegisterResponse
import com.android.lumashop.models.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("/register")
    fun registerUser(
        @Body request: RegisterRequest
    ): Call<RegisterResponse>

    @POST("/login")
    fun loginUser(
        @Body request: LoginRequest
    ): Call<LoginResponse>


    @GET("/product")
    fun getAllProducts(): Call<APIResponse<List<Product>>>

    @GET("/product/{id}")
    fun getProductById(
        @Path("id") productId: String
    ): Call<APIResponse<Product>>
}
