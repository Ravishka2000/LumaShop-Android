package com.android.lumashop.fragments.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.adapters.OrderProductsAdapter
import com.android.lumashop.databinding.FragmentTrackOrdersBinding
import com.android.lumashop.models.CartItem
import com.android.lumashop.models.Order
import com.android.lumashop.models.OrderStatusEnum
import com.android.lumashop.utils.OrderManager

class TrackOrdersFragment : Fragment() {

    private var _binding: FragmentTrackOrdersBinding? = null
    private val binding get() = _binding!!

    private lateinit var productsAdapter: OrderProductsAdapter // Adapter for products

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrackOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve order ID from arguments
        val orderId = arguments?.getString("orderId")
        val order = OrderManager.getOrderById(orderId) // Implement this method to get the order details

        if (order != null) {
            displayOrderDetails(order)
            setupRecyclerView(order.items) // Assuming order.items is a list of products
        }

        binding.imageCloseOrder.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack() // Close the fragment
        }
    }

    private fun displayOrderDetails(order: Order) {
        binding.tvOrderId.text = order.id
        "$${order.totalAmount}".also { binding.tvTotalPrice.text = it }

        binding.apply {
            stepView.setSteps(
                mutableListOf(
                    OrderStatusEnum.PENDING.name,
                    OrderStatusEnum.IN_PROGRESS.name,
                    OrderStatusEnum.DELIVERED.name,
                    OrderStatusEnum.COMPLETED.name,
                )
            )
            val currentOrderState = when (order.status) {
                OrderStatusEnum.PENDING -> 0
                OrderStatusEnum.IN_PROGRESS -> 1
                OrderStatusEnum.DELIVERED -> 2
                OrderStatusEnum.COMPLETED -> 3
                OrderStatusEnum.CANCELLED -> 3
            }

            stepView.go(currentOrderState, false)
            if (currentOrderState == 3) {
                stepView.done(true)
            }

        }
    }

    private fun setupRecyclerView(products: List<CartItem>) {
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        productsAdapter = OrderProductsAdapter(products)
        binding.rvProducts.adapter = productsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
