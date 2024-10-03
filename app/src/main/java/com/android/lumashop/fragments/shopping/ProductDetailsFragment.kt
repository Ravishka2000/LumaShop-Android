package com.android.lumashop.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.lumashop.data.SampleData
import com.android.lumashop.databinding.FragmentProductDetailsBinding
import com.bumptech.glide.Glide

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

        product?.let {
            binding.productName.text = it.name
            binding.productDescription.text = it.description
            binding.productPrice.text = "$${it.price}"

            Glide.with(this)
                .load(it.productImages?.firstOrNull())
                .into(binding.productImage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
