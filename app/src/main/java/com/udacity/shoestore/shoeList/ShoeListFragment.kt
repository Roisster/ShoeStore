package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeSharedVM by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach { shoe ->

                DataBindingUtil.inflate<ShoeItemBinding>(
                    inflater,
                    R.layout.shoe_item,
                    binding.llShoeList,
                    true
                ).also { it.shoe = shoe }
                    .also { it.viewModel = viewModel }
            }
        })

        viewModel.openCard.observe(viewLifecycleOwner, Observer {
            if (it.second) {
                findNavController().navigate(
                    ShoeListFragmentDirections.actionShoeListFragmentToShoeFragment(
                        it.first
                    )
                )
                viewModel.cardOpened()
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addFab.setOnClickListener {
            findNavController().navigate(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeFragment(null)
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)

    }
}