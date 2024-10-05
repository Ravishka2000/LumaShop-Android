package com.android.lumashop.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.R
import com.android.lumashop.databinding.CartProductItemBinding
import com.android.lumashop.models.CartItem
import com.android.lumashop.utils.CartManager

class CartAdapter(private var cartItems: MutableList<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(), CartManager.CartUpdateListener {

    init {
        CartManager.setCartUpdateListener(this) // Register this adapter as a listener
    }

    inner class CartViewHolder(val binding: CartProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cartItem: CartItem) {
            binding.tvProductCartName.text = cartItem.product.name
            "$${cartItem.product.price * cartItem.quantity}".also { binding.tvProductCartPrice.text = it }
            cartItem.quantity.toString().also { binding.tvCartProductQuantity.text = it }

            // Set product image
            cartItem.product.productImages?.let { images ->
                if (images.isNotEmpty()) {
                    binding.imageCartProduct.setImageResource(images[0]) // Ensure images array has valid resources
                } else {
                    binding.imageCartProduct.setImageResource(R.color.g_blue) // Default color
                }
            }

            try {
                val color = Color.parseColor(cartItem.color)
                binding.imageCartProductColor.setColorFilter(color)
            } catch (e: IllegalArgumentException) {
                binding.imageCartProductColor.setColorFilter(Color.parseColor("#0000fe")) // Default color
            }

            binding.imageMinus.setOnClickListener {
                CartManager.removeFromCart(cartItem.product)
            }

            binding.imagePlus.setOnClickListener {
                CartManager.addToCart(cartItem) // Use the add method to handle quantity updates
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cartItems[position])
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun updateCartItems(newCartItems: List<CartItem>) {
        cartItems.clear()
        cartItems.addAll(newCartItems)
        notifyDataSetChanged()
    }

    override fun onCartUpdated() {
        cartItems.clear() // Clear the current list
        cartItems.addAll(CartManager.getCartItems()) // Add updated cart items
        notifyDataSetChanged() // Notify the adapter to refresh the view
    }
}
