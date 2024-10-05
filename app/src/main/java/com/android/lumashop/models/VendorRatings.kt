package com.android.lumashop.models

import java.util.Date

data class VendorRatings(
    val id: String = "",
    val vendorId: String = "",
    val customerId: String = "",
    val rating: Int? = 0,
    val comment: String? = "",
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)