package com.android.lumashop.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.adapters.ProductColorsAdapter
import com.android.lumashop.adapters.ProductImagesAdapter
import com.android.lumashop.data.SampleData
import com.android.lumashop.databinding.FragmentProductDetailsBinding
import com.android.lumashop.models.CartItem
import com.android.lumashop.utils.CartManager
import com.google.android.material.snackbar.Snackbar

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!

    private var selectedColor: String = "#0000FF"  // Default color
    private var quantity: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productId = arguments?.getString("productId")
        val product = SampleData.productList.find { it.id == productId }

        product?.let { prod ->

            binding.productName.text = prod.name
            binding.productDescription.text = prod.description
            binding.productPrice.text = "$${prod.price}"
            binding.vendorID.text = "Vendor ID: ${prod.vendorId}"
            binding.tvAvailableQuantity.text = prod.stockQuantity.toString()

            // Display product dimensions if available
            binding.tvDimensionsValues.text = if (prod.dimensions != null) {
                "Width: ${prod.dimensions.width ?: "-"}cm, " +
                        "Height: ${prod.dimensions.height ?: "-"}cm, " +
                        "Depth: ${prod.dimensions.depth ?: "-"}cm"
            } else {
                "Dimensions not available"
            }

            // Set up the product images adapter
            val productImagesAdapter = ProductImagesAdapter(prod.productImages ?: emptyList())
            binding.viewPagerProductImages.adapter = productImagesAdapter

            // Set up the product colors adapter
            val productColorsAdapter = ProductColorsAdapter(prod.colorOptions ?: emptyList()) { color ->
                selectedColor = color  // Store selected color
            }
            binding.recyclerViewColors.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerViewColors.adapter = productColorsAdapter

            // Handle quantity increment and decrement
            binding.tvQuantity.text = quantity.toString()

            binding.btnIncreaseQuantity.setOnClickListener {
                if (quantity < prod.stockQuantity) {
                    quantity++
                    binding.tvQuantity.text = quantity.toString()
                } else {
                    Snackbar.make(view, "Max quantity reached", Snackbar.LENGTH_SHORT).show()
                }
            }

            binding.btnDecreaseQuantity.setOnClickListener {
                if (quantity > 1) {
                    quantity--
                    binding.tvQuantity.text = quantity.toString()
                }
            }

            // Handle Add to Cart button click
            binding.btnAddToCart.setOnClickListener {
                CartManager.addToCart(CartItem(prod, quantity, selectedColor))
                Snackbar.make(view, "${prod.name} added to cart", Snackbar.LENGTH_SHORT).show()
            }

            // Handle Purchase button click (for demonstration purposes)
            binding.btnPurchase.setOnClickListener {
                Snackbar.make(view, "Purchased ${prod.name}", Snackbar.LENGTH_SHORT).show()
            }

            // Handle vendor ID click to navigate to vendor details (to be implemented)
            binding.vendorID.setOnClickListener {
                navigateToVendorDetails(prod.vendorId)
            }
        }
    }

    // Navigate to vendor details fragment (implementation pending)
    private fun navigateToVendorDetails(vendorId: String) {
        val bundle = Bundle().apply {
            putString("vendorId", vendorId)
        }
        // Add navigation code here
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

