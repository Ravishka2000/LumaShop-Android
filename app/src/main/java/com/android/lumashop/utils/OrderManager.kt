package com.android.lumashop.utils

import com.android.lumashop.models.Order

object OrderManager {
    private val orders = mutableListOf<Order>()

    // Function to add a new order
    fun addOrder(order: Order) {
        orders.add(order.copy()) // Ensure a copy is added if you want to avoid mutability issues
    }

    // Function to get all orders
    fun getAllOrders(): List<Order> {
        return orders
    }

    fun getOrderById(orderId: String?): Order? {
        return orders.find { it.id == orderId }
    }
}

