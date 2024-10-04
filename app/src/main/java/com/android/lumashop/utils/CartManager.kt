package com.android.lumashop.utils

import com.android.lumashop.models.CartItem
import com.android.lumashop.models.Product

object CartManager {
    private val cartItems = mutableListOf<CartItem>()

    // Define an interface for cart update listener
    interface CartUpdateListener {
        fun onCartUpdated()
    }

    private var listener: CartUpdateListener? = null

    fun setCartUpdateListener(cartUpdateListener: CartUpdateListener) {
        listener = cartUpdateListener
    }

    fun addToCart(product: CartItem) {
        val existingItem = cartItems.find { it.product.id == product.product.id }
        if (existingItem != null) {
            existingItem.quantity += 1
        } else {
            cartItems.add(CartItem(product.product, product.quantity, product.color))
        }
        notifyCartUpdated()
    }

    fun removeFromCart(product: Product) {
        val cartItem = cartItems.find { it.product.id == product.id }
        cartItem?.let {
            if (it.quantity > 1) {
                it.quantity -= 1
            } else {
                cartItems.remove(it)
            }
        }
        notifyCartUpdated()
    }

    fun getCartItems(): List<CartItem> {
        return cartItems
    }

    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.product.price * it.quantity }
    }

    // Notify the listener about cart updates
    fun notifyCartUpdated() {
        listener?.onCartUpdated()
    }
}
