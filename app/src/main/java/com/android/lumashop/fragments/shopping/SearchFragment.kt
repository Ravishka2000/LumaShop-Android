package com.android.lumashop.fragments.shopping

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.R
import com.android.lumashop.adapters.ProductAdapter
import com.android.lumashop.data.SampleData
import com.android.lumashop.databinding.FragmentSearchBinding
import com.android.lumashop.models.Product

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var productAdapter: ProductAdapter
    private var productList: List<Product> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        loadProducts()
        setupSearchBar()
        return binding.root
    }

    private fun loadProducts() {
        productList = SampleData.productList

        Log.d("SearchFragment", "Loaded products: ${productList.size}")
    }

    private fun setupSearchBar() {
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext())

        productAdapter = ProductAdapter(emptyList()) { product ->
            navigateToProductDetails(product.id)
            Log.d("SearchFragment", "Clicked on product: ${product.name}")
        }

        binding.recyclerViewProducts.adapter = productAdapter

        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterProducts(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun filterProducts(query: String) {
        if (query.isEmpty()) {
            productAdapter.updateProducts(emptyList())
            binding.recyclerViewProducts.visibility = View.GONE
        } else {
            val filteredProducts = productList.filter { it.name.contains(query, ignoreCase = true) }

            productAdapter.updateProducts(filteredProducts)

            binding.recyclerViewProducts.visibility = if (filteredProducts.isNotEmpty()) View.VISIBLE else View.GONE

            Log.d("SearchFragment", "Filtering for \"$query\", found: ${filteredProducts.size}")
        }
    }
    private fun navigateToProductDetails(productId: String) {
        val productDetailsFragment = ProductDetailsFragment()

        val bundle = Bundle().apply {
            putString("productId", productId)
        }

        productDetailsFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, productDetailsFragment)
            .addToBackStack(null)
            .commit()

        Log.d("SearchFragment", "Navigating to ProductDetailsFragment with productId: $productId")
    }

}
