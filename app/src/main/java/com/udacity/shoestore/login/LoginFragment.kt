package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        // If the user has filled up both fields is validated and can navigate to the welcome fragment,
        // otherwise a Toast will show asking to check that both fields are completed
        viewModel.userValidated.observe(viewLifecycleOwner, Observer { userValidated ->
            if (userValidated) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else {
                Toast.makeText(context, "Check for missing inputs", Toast.LENGTH_LONG).show()
            }
        })
        return binding.root
    }

}