package com.android.lumashop.utils

import com.android.lumashop.models.VendorRatings
import com.android.lumashop.data.SampleData

object ReviewManager {

    private val vendorRatings = SampleData.vendorRatingsList.toMutableList()

    fun addReview(vendorId: String, customerId: String, rating: Int, comment: String) {
        val newReview = VendorRatings(
            id = "rating_${vendorRatings.size + 1}",
            vendorId = vendorId,
            customerId = customerId,
            rating = rating,
            comment = comment
        )
        vendorRatings.add(newReview)
    }

    fun getReviewsByVendorId(vendorId: String): List<VendorRatings> {
        return vendorRatings.filter { it.vendorId == vendorId }
    }
}
