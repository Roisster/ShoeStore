package com.udacity.shoestore.shoeList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe
import java.lang.IllegalArgumentException

class ShoeFragmentVMFactory(private val shoe: Shoe?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeFragmentVM::class.java)) {
            return ShoeFragmentVM(shoe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}