package com.android.lumashop.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lumashop.adapters.VendorRatingsAdapter
import com.android.lumashop.databinding.FragmentVendorDetailsBinding
import com.android.lumashop.data.SampleData
import com.android.lumashop.models.UserRoleEnum
import com.android.lumashop.utils.ReviewManager

class VendorDetailsFragment : Fragment() {

    private var _binding: FragmentVendorDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVendorDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vendorId = arguments?.getString("vendorId")
        val vendor = SampleData.userList.find { it.id == vendorId && it.role == UserRoleEnum.VENDOR }

        vendor?.let {
            binding.tvVendorName.text = "${it.firstName} ${it.lastName}"
            binding.tvDescription.text = it.description ?: "No description available"

            val ratings = SampleData.vendorRatingsList.filter { it.vendorId == vendorId }
            val ratingsAdapter = VendorRatingsAdapter(ratings)
            binding.recyclerViewRatings.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerViewRatings.adapter = ratingsAdapter

            binding.btnSubmitReview.setOnClickListener {
                val rating = binding.ratingBarVendor.rating.toInt()
                val comment = binding.etComment.text.toString()
                val customerId = "customer_id"

                if (rating > 0) {
                    ReviewManager.addReview(vendorId ?: "", customerId, rating, comment)
                    binding.etComment.text.clear()
                    val updatedRatings = ReviewManager.getReviewsByVendorId(vendorId ?: "")
                    ratingsAdapter.updateRatings(updatedRatings)
                    Toast.makeText(requireContext(), "Review submitted!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Please select a rating.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
