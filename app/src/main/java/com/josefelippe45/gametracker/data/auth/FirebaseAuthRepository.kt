package com.josefelippe45.gametracker.data.auth

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.josefelippe45.gametracker.domain.model.User
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository(
    private val auth: FirebaseAuth = Firebase.auth
): AuthRepository {

    override val currentUser: Flow<User?> = callbackFlow {
            val listener = FirebaseAuth.AuthStateListener { firebaseAuth ->
                val firebaseUser = firebaseAuth.currentUser
                val user = firebaseUser?.let {
                    User(
                        id = it.uid,
                        name = it.displayName.orEmpty(),
                        email = it.email.orEmpty()
                    )
                }
                trySend(user)
            }

            auth.addAuthStateListener(listener)
            awaitClose { auth.removeAuthStateListener(listener) }
        }

    override suspend fun login(
        email: String,
        password: String
    ): Result<Unit> {
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun signup(
        name: String,
        email: String,
        password: String
    ): Result<Unit> {
        try {
            auth.createUserWithEmailAndPassword(email, password).await()
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override fun logout() {
        auth.signOut()
    }
}