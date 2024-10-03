package com.android.lumashop.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.lumashop.fragments.categories.MainCategoryFragment
import com.android.lumashop.fragments.categories.ChairFragment
import com.android.lumashop.fragments.categories.CupboardFragment
import com.android.lumashop.fragments.categories.TableFragment

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainCategoryFragment()
            1 -> TableFragment()
            2 -> ChairFragment()
            3 -> CupboardFragment()
            else -> MainCategoryFragment()
        }
    }
}
