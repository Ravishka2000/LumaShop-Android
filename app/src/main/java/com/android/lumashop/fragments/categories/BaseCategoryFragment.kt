package com.android.lumashop.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.adapters.ProductAdapter
import com.android.lumashop.databinding.FragmentBaseCategoryBinding
import com.android.lumashop.models.Product

abstract class BaseCategoryFragment : Fragment() {

    private var _binding: FragmentBaseCategoryBinding? = null
    private val binding get() = _binding!!

    abstract fun getCategoryProducts(): List<Product> // Abstract method to be implemented by subclasses

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBaseCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get filtered products for the category
        val productAdapter = ProductAdapter(getCategoryProducts())

        // Setup RecyclerView
        binding.recyclerViewCategory.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
