package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.databinding.ItemProductImageBinding

class ProductImagesAdapter(private val images: List<Int>) : RecyclerView.Adapter<ProductImagesAdapter.ProductImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductImageViewHolder {
        val binding = ItemProductImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductImageViewHolder, position: Int) {
        val imageResId = images[position]
        holder.binding.imageView.setImageResource(imageResId)
    }

    override fun getItemCount() = images.size

    inner class ProductImageViewHolder(val binding: ItemProductImageBinding) : RecyclerView.ViewHolder(binding.root)
}
