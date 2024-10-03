package com.android.lumashop.models

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    val vendorId: String,
    val isArchived: Boolean = false,
    val stockQuantity: Int,
    val dimensions: Dimensions?,
    val material: String? = "",
    val colorOptions: List<String>? = emptyList(),
    val weight: Double? = null,
    val assemblyRequired: Boolean? = false,
    val productImages: List<Int>? = emptyList(),
    val warrantyPeriod: Int? = null,
    val isFeatured: Boolean? = false,
    val listingId: String,
    val createdAt: String,
    val updatedAt: String
)

data class Dimensions(
    val width: Double?,
    val height: Double?,
    val depth: Double?
)
