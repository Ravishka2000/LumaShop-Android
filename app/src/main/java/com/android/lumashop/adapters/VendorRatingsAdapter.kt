package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.databinding.ItemVendorRatingBinding
import com.android.lumashop.models.VendorRatings

class VendorRatingsAdapter(private var ratingsList: List<VendorRatings>) :
    RecyclerView.Adapter<VendorRatingsAdapter.VendorRatingViewHolder>() {

    // ViewHolder class for binding rating data to the item view
    inner class VendorRatingViewHolder(private val binding: ItemVendorRatingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(rating: VendorRatings) {
            binding.ratingBar.rating = rating.rating?.toFloat() ?: 0f
            binding.tvComment.text = rating.comment ?: "No comment"
            binding.tvDate.text = rating.createdAt.toString()
        }
    }

    // Inflate item layout and create ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorRatingViewHolder {
        val binding = ItemVendorRatingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VendorRatingViewHolder(binding)
    }

    // Update the list of ratings and refresh the RecyclerView
    fun updateRatings(newRatings: List<VendorRatings>) {
        ratingsList = newRatings
        notifyDataSetChanged()
    }

    // Bind rating data to the ViewHolder
    override fun onBindViewHolder(holder: VendorRatingViewHolder, position: Int) {
        holder.bind(ratingsList[position])
    }

    // Return the total number of ratings
    override fun getItemCount(): Int {
        return ratingsList.size
    }
}
