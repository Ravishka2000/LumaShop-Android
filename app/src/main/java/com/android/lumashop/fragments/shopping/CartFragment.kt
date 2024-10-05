package com.android.lumashop.fragments.shopping

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.adapters.CartAdapter
import com.android.lumashop.databinding.FragmentCartBinding
import com.android.lumashop.models.Order
import com.android.lumashop.models.User
import com.android.lumashop.models.UserRoleEnum
import com.android.lumashop.models.UserStatusEnum
import com.android.lumashop.utils.CartManager
import com.android.lumashop.utils.OrderManager

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cartAdapter = CartAdapter(CartManager.getCartItems().toMutableList())

        binding.rvCart.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cartAdapter
        }

        binding.tvTotalPrice.text = CartManager.getTotalPrice().toString()

        binding.buttonCheckout.setOnClickListener {
            createOrder()
            Log.d("CartFragment", OrderManager.getAllOrders().toString())
        }
    }

    private fun createOrder() {
        val cartItems = CartManager.getCartItems().map { it.copy() } // Create copies of the cart items
        Log.d("CartFragment", "Cart Items: $cartItems") // Log cart items

        val totalAmount = CartManager.getTotalPrice()

        val newOrder = Order(
            id = generateOrderId(),
            customerId = User("u10", "Ravi", "Dulshan", null, null, UserRoleEnum.CUSTOMER, UserStatusEnum.ACTIVE),
            items = cartItems, // Pass copied items
            totalAmount = totalAmount
        )

        // Log the created order
        Log.d("CartFragment", "New Order Created: $newOrder")

        // Add the order to OrderManager
        OrderManager.addOrder(newOrder)

        // Log orders after adding
        Log.d("CartFragment", "Orders after adding: ${OrderManager.getAllOrders()}")

        // Clear the cart and show a success message
        clearCart()
        showSuccessMessage("Order created successfully!")
    }

    private fun generateOrderId(): String {
        // Generate a unique ID for the order
        return "ORDER-${System.currentTimeMillis()}"
    }

    private fun clearCart() {
        CartManager.clearCart() // Clear the cart items from CartManager
        cartAdapter.updateCartItems(CartManager.getCartItems()) // Update the adapter
        binding.tvTotalPrice.text = "0.0" // Reset total price
    }

    private fun showSuccessMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
