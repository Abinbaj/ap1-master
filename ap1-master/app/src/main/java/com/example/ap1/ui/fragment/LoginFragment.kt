package com.example.ap1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ap1.databinding.FragmentLoginBinding
import com.example.ap1.viewmodels.LoginFragment_ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    // Create ViewModel instance with Hilt
    private val loginViewModel: LoginFragment_ViewModel by viewModels()

    // Declare a binding reference (use _binding to manage lifecycle)
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize ViewBinding
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up login button click listener using ViewBinding
        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in both fields", Toast.LENGTH_SHORT).show()
            } else {
                login(username, password)
            }
        }
    }

    private fun login(username: String, password: String) {
        loginViewModel.login(username, password).observe(viewLifecycleOwner) { result ->
            result.onSuccess { loginResponse ->
                Toast.makeText(requireContext(), "Login successful!", Toast.LENGTH_LONG).show()

                // Proceed with navigation
                val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment(loginResponse.keypass)
                findNavController().navigate(action)
            }

            result.onFailure { exception ->
                Toast.makeText(requireContext(), "Login failed: ${exception.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Nullify the binding reference when the view is destroyed to avoid memory leaks
        _binding = null
    }
}
