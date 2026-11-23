package com.example.profilejc.ui.screen.profile

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    var name by mutableStateOf("")
    var surname by mutableStateOf("")
    var email by mutableStateOf("")
    var isError by mutableStateOf(false)

    fun updateData(newName: String, newSurname: String, newEmail: String, newIsError: Boolean) {
        name = newName
        surname = newSurname
        email = newEmail
        isError = newIsError
    }

    fun validateEmail(email: String): Boolean {
        return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches().apply { isError = this }
    }
}