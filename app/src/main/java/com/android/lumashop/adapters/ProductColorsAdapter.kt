package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.databinding.ItemProductColorBinding

class ProductColorsAdapter(
    private val colors: List<String>,
    private val onColorSelected: (String) -> Unit
) : RecyclerView.Adapter<ProductColorsAdapter.ColorViewHolder>() {

    inner class ColorViewHolder(val binding: ItemProductColorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(color: String) {
            // Display color and handle selection
            binding.colorView.setBackgroundColor(android.graphics.Color.parseColor(color))
            binding.root.setOnClickListener {
                onColorSelected(color)  // Notify fragment about selected color
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val binding = ItemProductColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(colors[position])
    }

    override fun getItemCount(): Int {
        return colors.size
    }
}
