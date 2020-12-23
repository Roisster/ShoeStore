package com.udacity.shoestore.shoeList

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeSharedVM : ViewModel() {
    
    private val _openCard = MutableLiveData<Pair<Shoe, Boolean>>()
    val openCard: LiveData<Pair<Shoe, Boolean>>
        get() = _openCard

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    private val _validatedData = MutableLiveData<Boolean>()
    val validatedData: LiveData<Boolean>
        get() = _validatedData

    private val shoes = ArrayList<Shoe>()


    var shoe = Shoe("", 0.0, "", "")

    fun addShoe() {
        shoes.add(shoe)
        _shoeList.value = shoes
        _validatedData.value = true
    }

    fun navigationComplete() {
        _validatedData.value = false
        shoe = Shoe("", 0.0, "", "")
    }

    fun openCard(v: View, shoe: Shoe) {
        _openCard.value = Pair(shoe, true)
    }

    fun cardOpened() {
        _openCard.value = Pair(shoe, false)
    }
}