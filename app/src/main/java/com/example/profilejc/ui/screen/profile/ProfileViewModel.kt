package com.example.profilejc.ui.screen.profile

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ProfileUiState(
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val isError: Boolean = false
)

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun onNameChange(newName: String) {
        _uiState.update { it.copy(name = newName) }
    }

    fun onSurnameChange(newSurname: String) {
        _uiState.update { it.copy(surname = newSurname) }
    }

    fun onEmailChange(newEmail: String) {
        // Opcional: limpiamos el error mientras el usuario corrige el email
        _uiState.update { it.copy(email = newEmail, isError = false) }
    }

    fun onSubmit(onSuccess: () -> Unit) {
        val currentEmail = _uiState.value.email
        val valid = validateEmail(currentEmail)

        _uiState.update { it.copy(isError = !valid) }

        if (valid) {
            onSuccess()
        }
    }

    fun validateEmail(email: String): Boolean {
        return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}