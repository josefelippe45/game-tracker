package com.josefelippe45.gametracker.ui.feature.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.josefelippe45.gametracker.data.auth.AuthRepository
import com.josefelippe45.gametracker.data.auth.FirebaseAuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoginUIState(
    val isLoading: Boolean = false,
    val email: String = "",
    val name: String = "",
    val password: String = ""
)

class LoginViewModel(
    private val authRepository: AuthRepository = FirebaseAuthRepository()
): ViewModel() {
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState> = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        this._uiState.update { current -> current.copy(email = email) }
    }

    fun onNameChange(name: String) {
        this._uiState.update { current -> current.copy(name = name) }
    }

    fun onPasswordChange(password: String) {
        this._uiState.update { current -> current.copy(password = password) }
    }

    fun authenticate(): Unit {
        // Dentro do viewModel executamos coroutines com o launch
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val result = authRepository.login(
                uiState.value.email,
                uiState.value.password
            )
            _uiState.update { it.copy(isLoading = false) }
            result.onFailure {
                Log.e("LoginViewModel","Erro no login", it)
            }
            result.onSuccess {
                Log.i("LoginViewModel", "Login feito com sucesso!")
            }
        }
    }
}