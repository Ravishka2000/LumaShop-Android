package com.android.lumashop.fragments.categories

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.R
import com.android.lumashop.adapters.ProductAdapter
import com.android.lumashop.databinding.FragmentBaseCategoryBinding
import com.android.lumashop.models.Product
import com.android.lumashop.dto.APIResponse
import com.android.lumashop.utils.RetrofitClient
import com.android.lumashop.api.ApiService
import com.android.lumashop.fragments.shopping.ProductDetailsFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainCategoryFragment : Fragment() {

    private var _binding: FragmentBaseCategoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter
    private val apiService: ApiService by lazy {
        RetrofitClient.getClient(requireActivity()).create(ApiService::class.java)
    }

    override fun onCreateView(
        inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBaseCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter = ProductAdapter(emptyList()) { product ->
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

        fetchProductsFromApi()
    }

    private fun fetchProductsFromApi() {
        apiService.getAllProducts().enqueue(object : Callback<APIResponse<List<Product>>> {
            override fun onResponse(
                call: Call<APIResponse<List<Product>>>,
                response: Response<APIResponse<List<Product>>>
            ) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val products = apiResponse?.data ?: emptyList()

                    productAdapter.updateProducts(products)
                } else {
                    Toast.makeText(requireContext(), "Failed to load products", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<APIResponse<List<Product>>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
