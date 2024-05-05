package com.android.darknesshabittracker.Navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.darknesshabittracker.authentication.presentation.OptionButtons
import com.android.darknesshabittracker.authentication.presentation.RegistrationScreen

class Navigation() {
    @Composable
    fun AppNavigation(
        context: Context
    ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                OptionButtons() {
                    navController.navigate("registrationScreen")
                }
            }

            composable("registrationScreen") {
                RegistrationScreen(
                    context = context,
                ) {
                    navController.popBackStack()
                }
            }
        }
    }

}

