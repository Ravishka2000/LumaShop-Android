package com.android.lumashop.models

data class CartItem(
    val product: Product,
    var quantity: Int,
    var color: String
)
