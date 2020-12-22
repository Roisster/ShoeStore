package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeBinding

class ShoeFragment : Fragment() {

    private lateinit var binding: FragmentShoeBinding
    private val shoesVM: ShoeSharedVM by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe,
            container,
            false
        )

        binding.lifecycleOwner = this
        binding.viewModel = shoesVM

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*shoesVM.validatedData.observe(viewLifecycleOwner, Observer { isValidated ->
            if (isValidated) {
                findNavController().navigate(ShoeFragmentDirections.actionShoeFragmentToShoeListFragment2())
            } else {
                Toast.makeText(
                    requireContext(),
                    "There was a problem validating your data",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })*/

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}