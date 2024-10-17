package com.android.lumashop.fragments.loginRegister

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.lumashop.activities.ShoppingActivity
import com.android.lumashop.api.ApiService
import com.android.lumashop.databinding.FragmentLoginBinding
import com.android.lumashop.dto.LoginRequest
import com.android.lumashop.dto.LoginResponse
import com.android.lumashop.utils.RetrofitClient
import com.android.lumashop.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentLogin : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var apiService: ApiService
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiService = RetrofitClient.getClient(requireActivity()).create(ApiService::class.java)
        sessionManager = SessionManager(requireContext())

        binding.buttonLoginLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email = binding.edEmailLogin.text.toString().trim()
        val password = binding.edPasswordLogin.text.toString().trim()

        // Validate input fields
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Create a LoginRequest
        val loginRequest = LoginRequest(email, password)

        // Call the API
        apiService.loginUser(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val loginResponse = response.body()!!
                    if (loginResponse.success) {
                        // Save the token and user information in SharedPreferences
                        sessionManager.saveAuthToken(loginResponse.accessToken!!, loginResponse.email!!, loginResponse.userId!!)

                        // Show success message
                        Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show()

                        // Navigate to ShoppingActivity
                        navigateToShoppingActivity()
                    } else {
                        Toast.makeText(requireContext(), "Login failed: ${loginResponse.message}", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Login failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun navigateToShoppingActivity() {
        val intent = Intent(requireContext(), ShoppingActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Close the login activity
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Clean up binding to avoid memory leaks
    }
}
