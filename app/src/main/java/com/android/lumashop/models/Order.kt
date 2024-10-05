package com.android.lumashop.models

import java.util.Date

data class Order(
    val id: String = "",
    val customerId: User,
    val items: List<CartItem>,
    val totalAmount: Double,
    val status: OrderStatusEnum = OrderStatusEnum.PENDING,
    val createdBy: String = "",
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val isArchive: Boolean = false
)

enum class OrderStatusEnum(val value: Int) {
    PENDING(5),
    IN_PROGRESS(10),
    DELIVERED(15),
    CANCELLED(20),
    COMPLETED(25)
}