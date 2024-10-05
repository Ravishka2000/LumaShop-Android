package com.android.lumashop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lumashop.databinding.OrderItemBinding
import com.android.lumashop.models.Order

class AllOrdersAdapter(
    private val orders: List<Order>,
    private val onOrderClick: (Order) -> Unit // Callback for item click
) : RecyclerView.Adapter<AllOrdersAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = OrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.bind(order)

        // Set click listener for each order item
        holder.itemView.setOnClickListener {
            onOrderClick(order)
        }
    }

    override fun getItemCount() = orders.size

    inner class OrderViewHolder(private val binding: OrderItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            // Bind your order data to the view
            binding.tvOrderId.text = order.id
            binding.tvTotalAmount.text = order.totalAmount.toString()
            binding.tvOrderStatus.text = order.status.name
        }
    }
}

