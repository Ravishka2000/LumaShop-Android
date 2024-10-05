package com.android.lumashop.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.R
import com.android.lumashop.adapters.AllOrdersAdapter
import com.android.lumashop.databinding.FragmentAllOrdersBinding
import com.android.lumashop.models.Order
import com.android.lumashop.utils.OrderManager

class AllOrdersFragment : Fragment() {

    private var _binding: FragmentAllOrdersBinding? = null
    private val binding get() = _binding!!

    private lateinit var allOrdersAdapter: AllOrdersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        displayOrders()
    }

    private fun setupRecyclerView() {
        binding.rvAllOrders.layoutManager = LinearLayoutManager(requireContext())
        allOrdersAdapter = AllOrdersAdapter(emptyList()) { order ->
            navigateToTrackOrdersFragment(order) // Handle item click
        }
        binding.rvAllOrders.adapter = allOrdersAdapter
    }

    private fun displayOrders() {
        val orders = OrderManager.getAllOrders()
        allOrdersAdapter = AllOrdersAdapter(orders) { order ->
            navigateToTrackOrdersFragment(order)
        }
        binding.rvAllOrders.adapter = allOrdersAdapter

        // Show or hide empty orders view based on order count
        if (orders.isEmpty()) {
            binding.tvEmptyOrders.visibility = View.VISIBLE
            binding.rvAllOrders.visibility = View.GONE
        } else {
            binding.tvEmptyOrders.visibility = View.GONE
            binding.rvAllOrders.visibility = View.VISIBLE
        }
    }

    private fun navigateToTrackOrdersFragment(order: Order) {
        val fragment = TrackOrdersFragment()
        val bundle = Bundle().apply {
            putString("orderId", order.id) // Pass the order ID or other relevant data
        }
        fragment.arguments = bundle

        // Navigate to TrackOrdersFragment
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment) // Update with your container ID
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
