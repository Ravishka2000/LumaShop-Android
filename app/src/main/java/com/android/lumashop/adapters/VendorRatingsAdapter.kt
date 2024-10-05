package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.databinding.ItemVendorRatingBinding
import com.android.lumashop.models.VendorRatings

class VendorRatingsAdapter(private var ratingsList: List<VendorRatings>) :
    RecyclerView.Adapter<VendorRatingsAdapter.VendorRatingViewHolder>() {

    inner class VendorRatingViewHolder(private val binding: ItemVendorRatingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(rating: VendorRatings) {
            binding.ratingBar.rating = rating.rating?.toFloat() ?: 0f
            binding.tvComment.text = rating.comment ?: "No comment"
            binding.tvDate.text = rating.createdAt.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorRatingViewHolder {
        val binding = ItemVendorRatingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VendorRatingViewHolder(binding)
    }

    fun updateRatings(newRatings: List<VendorRatings>) {
        ratingsList = newRatings
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VendorRatingViewHolder, position: Int) {
        holder.bind(ratingsList[position])
    }

    override fun getItemCount(): Int {
        return ratingsList.size
    }
}
