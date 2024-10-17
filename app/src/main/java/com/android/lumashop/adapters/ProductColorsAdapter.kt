package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.databinding.ItemProductColorBinding

class ProductColorsAdapter(// Adapter for displaying a list of colors
    private val colors: List<String>,
    private val onColorSelected: (String) -> Unit
) : RecyclerView.Adapter<ProductColorsAdapter.ColorViewHolder>() {

    // ViewHolder class for binding color data to the item view
    inner class ColorViewHolder(val binding: ItemProductColorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(color: String) {
            // Display color and handle selection
            binding.colorView.setBackgroundColor(android.graphics.Color.parseColor(color))
            binding.root.setOnClickListener {
                onColorSelected(color)  // Notify fragment about selected color
            }
        }
    }

    // Inflate item layout and create ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val binding = ItemProductColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColorViewHolder(binding)
    }

    // Bind color data to the ViewHolder
    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(colors[position])
    }

    // Return the total number of colors
    override fun getItemCount(): Int {
        return colors.size
    }
}
