package com.josefelippe45.gametracker.ui.feature.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class SignupUIState(
    val isLoading: Boolean = false,
    val email: String = "",
    val name: String = "",
    val password: String = ""
)

class SignupViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SignupUIState())
    val uiState: StateFlow<SignupUIState> = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        this._uiState.update { current -> current.copy(email = email) }
    }

    fun onNameChange(name: String) {
        this._uiState.update { current -> current.copy(name = name) }
    }

    fun onPasswordChange(password: String) {
        this._uiState.update { current -> current.copy(password = password) }
    }
}