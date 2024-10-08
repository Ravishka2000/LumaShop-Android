package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.models.Product
import com.android.lumashop.databinding.ItemProductBinding
import com.bumptech.glide.Glide


class ProductAdapter(// Adapter class for handling the display of a list of products in a RecyclerView
    private var products: List<Product>,
    private val onProductClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // ViewHolder class that binds the product data to the UI elements in the item view
    inner class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.apply {
                productName.text = product.name
                "$${product.price}".also { productPrice.text = it }
                productDescription.text = product.description

                Glide.with(itemView.context)
                    .load(product.productImages?.firstOrNull())
                    .into(productImage)

                itemView.setOnClickListener {
                    onProductClick(product)
                }
            }
        }
    }
    // Called when the ViewHolder is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    // Called when data needs to be bound to the ViewHolder at a given position
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    // Returns the total number of items in the list
    override fun getItemCount(): Int = products.size

    // Function to update the list of products and refresh the RecyclerView
    fun updateProducts(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()
    }
}
