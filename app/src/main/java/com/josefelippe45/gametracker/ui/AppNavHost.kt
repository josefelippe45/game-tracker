package com.josefelippe45.gametracker.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.josefelippe45.gametracker.data.auth.AuthRepository
import com.josefelippe45.gametracker.data.auth.FirebaseAuthRepository
import com.josefelippe45.gametracker.ui.feature.auth.LoginScreen
import com.josefelippe45.gametracker.ui.feature.auth.SignupScreen
import com.josefelippe45.gametracker.ui.feature.auth.WelcomeScreen
import com.josefelippe45.gametracker.ui.feature.groups.GroupsScreen

object Routes {
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val SIGNUP = "signup"
    const val GROUPS = "groups"
}

@Composable
fun AppNavHost(
    authRepository: AuthRepository = FirebaseAuthRepository()
) {
    val navController = rememberNavController()
    val user by authRepository.currentUser.collectAsStateWithLifecycle(initialValue = null)

    val startDestination = if (user == null) Routes.WELCOME else Routes.GROUPS

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.WELCOME) {
            WelcomeScreen(
                onLoginClick = { navController.navigate(Routes.LOGIN) },
                onSignUpClick = { navController.navigate(Routes.SIGNUP) }
            )
        }
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.GROUPS) {
                        popUpTo(Routes.LOGIN) {inclusive = true}
                    }
                },
                onBack = {navController.popBackStack()}
            )
        }
        composable(Routes.SIGNUP) {
            SignupScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Routes.GROUPS) {
            GroupsScreen()
        }
    }
}