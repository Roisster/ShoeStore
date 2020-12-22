package com.udacity.shoestore.shoeList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeSharedVM : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    /*private val _validatedData = MutableLiveData<Boolean>()
    val validatedData: LiveData<Boolean>
        get() = _validatedData*/


    val shoes = mutableListOf<Shoe>()

    fun addShoe(shoe: Shoe?) {
        Log.d("AS", "${shoe}")
        /*shoe?.let { shoes.add(it) }
        _shoeList.value = shoes
        _validatedData.value = true*/

    }

    fun getCard() {
        Log.d("SSVM", "Entro en Shared")
    }
}