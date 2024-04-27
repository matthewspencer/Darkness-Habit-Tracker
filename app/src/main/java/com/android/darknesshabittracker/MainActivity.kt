package com.android.darknesshabittracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.darknesshabittracker.ui.theme.RegistrationScreen
import com.android.darknesshabittracker.ui.theme.Options
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()

        }

        auth = Firebase.auth

    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser == null) {
            Toast.makeText(this, "Please, log into the system", Toast.LENGTH_SHORT).show()
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

