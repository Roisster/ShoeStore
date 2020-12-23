package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeBinding

class ShoeFragment : Fragment() {

    private lateinit var binding: FragmentShoeBinding
    private lateinit var viewShoeVM: ShoeFragmentVM
    private lateinit var viewShoeVMFactory: ShoeFragmentVMFactory
    private val shoesVM: ShoeSharedVM by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe,
            container,
            false
        )
        val shoeArgs: ShoeFragmentArgs by navArgs()

        viewShoeVMFactory = ShoeFragmentVMFactory(shoeArgs.shoe)
        viewShoeVM = ViewModelProvider(this, viewShoeVMFactory).get(ShoeFragmentVM::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = shoesVM
        binding.shoe = shoesVM.shoe

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shoesVM.validatedData.observe(viewLifecycleOwner, Observer { isValidated ->
            if (isValidated) {
                findNavController().navigate(ShoeFragmentDirections.actionShoeFragmentToShoeListFragment2())
                shoesVM.navigationComplete()
            }
        })

        viewShoeVM.viewShoe.observe(viewLifecycleOwner, Observer { shoe ->
            with(binding) {
                this.shoe = shoe
                btnSave.visibility = View.GONE
            }
        })

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}