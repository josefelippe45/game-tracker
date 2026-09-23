package com.josefelippe45.gametracker.data.auth

import com.josefelippe45.gametracker.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser: Flow<User?>
    suspend fun login(email: String, password: String): Result<Unit>;
    suspend fun signup(name: String, email: String, password: String): Result<Unit>;
    fun logout()
}