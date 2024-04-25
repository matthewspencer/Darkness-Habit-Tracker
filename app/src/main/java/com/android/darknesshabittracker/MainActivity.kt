package com.android.darknesshabittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.darknesshabittracker.ui.theme.RegistrationScreen
import com.android.darknesshabittracker.ui.theme.Options

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                Options() {
                    navController.navigate("registrationScreen")
                }
            }

            composable("registrationScreen") {
                RegistrationScreen() {
                    navController.popBackStack()
                }
            }
        }
    }

    val animationSpec = tween<Float>(

    )
}

