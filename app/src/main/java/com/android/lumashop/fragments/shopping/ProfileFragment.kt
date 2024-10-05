package com.android.lumashop.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.lumashop.R
import com.android.lumashop.databinding.FragmentProfileBinding
import com.android.lumashop.fragments.settings.AllOrdersFragment
import com.android.lumashop.fragments.settings.EditProfileFragment
import com.android.lumashop.fragments.settings.TrackOrdersFragment

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up click listeners
        binding.linearAllOrders.setOnClickListener {
            loadSubFragment(AllOrdersFragment())
        }

        binding.linearTrackOrder.setOnClickListener {
            loadSubFragment(TrackOrdersFragment())
        }

        binding.constraintProfile.setOnClickListener {
            loadSubFragment(EditProfileFragment())
        }
    }

    private fun loadSubFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
