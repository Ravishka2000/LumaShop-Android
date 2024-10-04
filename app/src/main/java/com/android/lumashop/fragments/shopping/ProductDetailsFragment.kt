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
import com.google.android.material.snackbar.Snackbar

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!

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

            binding.tvDimensionsValues.text = if (prod.dimensions != null) {
                "Width: ${prod.dimensions.width ?: "-"}cm, " +
                        "Height: ${prod.dimensions.height ?: "-"}cm, " +
                        "Depth: ${prod.dimensions.depth ?: "-"}cm"
            } else {
                "Dimensions not available"
            }

            val productImagesAdapter = ProductImagesAdapter(prod.productImages ?: emptyList())
            binding.viewPagerProductImages.adapter = productImagesAdapter

            val productColorsAdapter = ProductColorsAdapter(prod.colorOptions ?: emptyList())
            binding.recyclerViewColors.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerViewColors.adapter = productColorsAdapter

            var quantity = 1
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

            binding.btnAddToCart.setOnClickListener {
                Snackbar.make(view, "${prod.name} added to cart", Snackbar.LENGTH_SHORT).show()
            }

            binding.btnPurchase.setOnClickListener {
                Snackbar.make(view, "Purchased ${prod.name}", Snackbar.LENGTH_SHORT).show()
            }

            binding.vendorID.setOnClickListener {
            }
        }
    }

    private fun navigateToVendorDetails(vendorId: String) {
        val bundle = Bundle().apply {
            putString("vendorId", vendorId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
