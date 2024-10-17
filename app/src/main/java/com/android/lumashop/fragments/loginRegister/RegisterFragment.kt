package com.android.lumashop.fragments.loginRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.lumashop.R
import com.android.lumashop.api.ApiService
import com.android.lumashop.databinding.FragmentRegisterBinding
import com.android.lumashop.dto.RegisterRequest
import com.android.lumashop.dto.RegisterResponse
import com.android.lumashop.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentRegister : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var apiService: ApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout and initialize view binding
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Initialize ApiService
        apiService = RetrofitClient.getClient(requireActivity()).create(ApiService::class.java)

        // Handle register button click
        binding.buttonRegisterRegister.setOnClickListener {
            registerUser()
        }

        return binding.root
    }

    private fun registerUser() {
        val firstName = binding.edFirstNameRegister.text.toString().trim()
        val lastName = binding.edLastNameRegister.text.toString().trim()
        val email = binding.edEmailRegister.text.toString().trim()
        val password = binding.edPasswordRegister.text.toString().trim()
        val confirmPassword = binding.edConfirmPasswordRegister.text.toString().trim()

        // Validate input
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Prepare register request DTO
        val registerRequest = RegisterRequest(firstName, lastName, email, password, confirmPassword)

        // Make the API call
        apiService.registerUser(registerRequest).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "Registration successful", Toast.LENGTH_SHORT).show()
                    navigateToLoginFragment()
                } else {
                    Toast.makeText(requireContext(), "Registration failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun navigateToLoginFragment() {
        val loginFragment = FragmentLogin()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, loginFragment)
            .addToBackStack(null)
            .commit()
    }
}
