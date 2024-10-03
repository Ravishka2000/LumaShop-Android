package com.android.lumashop.fragments.categories

import com.android.lumashop.data.SampleData
import com.android.lumashop.models.Product

class TableFragment : BaseCategoryFragment() {

    override fun getCategoryProducts(): List<Product> {
        // Filter products by category "Table"
        return SampleData.productList.filter { it.category == "Table" }
    }
}
