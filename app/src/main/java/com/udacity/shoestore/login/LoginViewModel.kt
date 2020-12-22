package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    // Set up for the Observable at loginFragment.kt
    private val _userValidated = MutableLiveData<Boolean>()
    val userValidated: LiveData<Boolean>
        get() = _userValidated

    // 2 way DataBinding inputs, taking the inputs directly from fragment_login.xml
    var userMail: String = ""
    var userPassword: String = ""

    // Validate that both fields have been introduced and add the result to an observable LiveData to be used by LoginFragment.kt
    fun validateInputs() {
        _userValidated.value =
            userMail.isNotEmpty() && userPassword.isNotEmpty()
    }
}