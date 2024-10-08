package com.android.lumashop.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.R
import com.android.lumashop.adapters.ProductAdapter
import com.android.lumashop.databinding.FragmentBaseCategoryBinding
import com.android.lumashop.fragments.shopping.ProductDetailsFragment
import com.android.lumashop.models.Product

abstract class BaseCategoryFragment : Fragment() {

    private var _binding: FragmentBaseCategoryBinding? = null
    private val binding get() = _binding!!

    abstract fun getCategoryProducts(): List<Product>

    // Inflate the layout and set up binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBaseCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Set up the RecyclerView with products when the view is created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productAdapter = ProductAdapter(getCategoryProducts()) { product ->
            val productDetailsFragment = ProductDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString("productId", product.id)
                }
            }

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, productDetailsFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerViewCategory.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }

    // Clean up the binding reference when the view is destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
