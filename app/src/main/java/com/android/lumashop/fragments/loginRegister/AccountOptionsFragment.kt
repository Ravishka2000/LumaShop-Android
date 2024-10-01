package com.android.lumashop.fragments.loginRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.lumashop.R
import com.android.lumashop.databinding.FragmentAccountOptionsBinding

class FragmentAccountOptions : Fragment() {

    private var _binding: FragmentAccountOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listeners for the buttons
        binding.buttonRegisterAccountOptions.setOnClickListener {
            // Navigate to FragmentRegister
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentRegister())
                .addToBackStack(null)
                .commit()
        }

        binding.buttonLoginAccountOptions.setOnClickListener {
            // Navigate to FragmentLogin
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentLogin())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
