package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.databinding.ItemProductImageBinding

class ProductImagesAdapter(private val images: List<Int>) : RecyclerView.Adapter<ProductImagesAdapter.ProductImageViewHolder>() {

    // Inflate item layout and create ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductImageViewHolder {
        val binding = ItemProductImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductImageViewHolder(binding)
    }

    // Bind image resource to the ImageView
    override fun onBindViewHolder(holder: ProductImageViewHolder, position: Int) {
        val imageResId = images[position]
        holder.binding.imageView.setImageResource(imageResId)
    }

    // Return the total number of images
    override fun getItemCount() = images.size

    // ViewHolder class for the product image
    inner class ProductImageViewHolder(val binding: ItemProductImageBinding) : RecyclerView.ViewHolder(binding.root)
}
