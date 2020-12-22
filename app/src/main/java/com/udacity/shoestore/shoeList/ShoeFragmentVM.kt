package com.udacity.shoestore.shoeList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeFragmentVM(shoe: Shoe?) : ViewModel() {

    private val _viewShoe = MutableLiveData<Shoe>()
    val viewShoe: LiveData<Shoe>
        get() = _viewShoe

    init {
        if(shoe != null) {
            _viewShoe.value = shoe
        }
    }
}