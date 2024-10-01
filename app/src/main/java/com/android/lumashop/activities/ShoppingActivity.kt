package com.android.lumashop.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.lumashop.R
import com.android.lumashop.fragments.HomeFragment
import com.android.lumashop.fragments.shopping.SearchFragment
import com.android.lumashop.fragments.shopping.CartFragment
import com.android.lumashop.fragments.shopping.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Set initial fragment (HomeFragment)
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> loadFragment(HomeFragment())
                R.id.searchFragment -> loadFragment(SearchFragment())
                R.id.cartFragment -> loadFragment(CartFragment())
                R.id.profileFragment -> loadFragment(ProfileFragment())
            }
            true
        }
    }

    // Helper function to load a fragment into the container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
