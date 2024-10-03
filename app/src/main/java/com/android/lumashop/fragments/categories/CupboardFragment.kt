package com.android.lumashop.fragments.categories

import com.android.lumashop.data.SampleData
import com.android.lumashop.models.Product

class CupboardFragment : BaseCategoryFragment() {

    override fun getCategoryProducts(): List<Product> {
        // Filter products by category "Cupboard"
        return SampleData.productList.filter { it.category == "Cupboard" }
    }
}
