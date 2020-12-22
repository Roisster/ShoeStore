package com.udacity.shoestore.shoeList

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.models.Shoe

class ShoeSharedVM : ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    private val _validatedData = MutableLiveData<Boolean>()
    val validatedData: LiveData<Boolean>
        get() = _validatedData

    private val shoes = ArrayList<Shoe>()
    var shoe = Shoe("", "", "")

    fun addShoe(s: Shoe) {
        shoes.add(s)
        _shoeList.value = shoes
        _validatedData.value = true
    }

    fun navigationComplete() {
        _validatedData.value = false
        shoe = Shoe("", "", "")
    }

    fun openCard(v: View, shoe: Shoe) {
        v.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeFragment(shoe))

    }
}