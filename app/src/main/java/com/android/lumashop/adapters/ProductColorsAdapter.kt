package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.databinding.ItemProductColorBinding

class ProductColorsAdapter(private val colors: List<String>?) : RecyclerView.Adapter<ProductColorsAdapter.ColorViewHolder>() {

    inner class ColorViewHolder(val binding: ItemProductColorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(color: String) {
            binding.colorView.setBackgroundColor(android.graphics.Color.parseColor(color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val binding = ItemProductColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        colors?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int {
        return colors?.size ?: 0
    }
}
