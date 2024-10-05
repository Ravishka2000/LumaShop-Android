package com.android.lumashop.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.R
import com.android.lumashop.databinding.BillingProductsRvItemBinding
import com.android.lumashop.models.CartItem

class OrderProductsAdapter(
    private val products: List<CartItem>
) : RecyclerView.Adapter<OrderProductsAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = BillingProductsRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount() = products.size

    inner class ProductViewHolder(private val binding: BillingProductsRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: CartItem) {
            binding.tvProductCartName.text = product.product.name // Assuming Product has a name property
            "$${product.product.price * product.quantity}".also { binding.tvProductCartPrice.text = it } // Assuming Product has a price property
            product.quantity.toString().also { binding.tvBillingProductQuantity.text = it } // Assuming Product has a quantity property
            product.product.productImages?.let { images ->
                if (images.isNotEmpty()) {
                    binding.imageCartProduct.setImageResource(images[0]) // Ensure images array has valid resources
                } else {
                    binding.imageCartProduct.setImageResource(R.color.g_blue) // Default color
                }
            }

            try {
                val color = Color.parseColor(product.color)
                binding.imageCartProductColor.setColorFilter(color)
            } catch (e: IllegalArgumentException) {
                binding.imageCartProductColor.setColorFilter(Color.parseColor("#0000fe")) // Default color
            }
        }
    }
}
