package com.android.lumashop.fragments.categories

import com.android.lumashop.data.SampleData
import com.android.lumashop.models.Product

class MainCategoryFragment : BaseCategoryFragment() {

    override fun getCategoryProducts(): List<Product> {
        return SampleData.productList
    }
}
