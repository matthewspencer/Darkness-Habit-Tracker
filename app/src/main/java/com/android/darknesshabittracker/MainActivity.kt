package com.android.darknesshabittracker

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.darknesshabittracker.Navigation.Navigation
import com.android.darknesshabittracker.authentication.domain.Authentication
import com.android.darknesshabittracker.authentication.domain.RegistrationScreenViewModel
import com.android.darknesshabittracker.authentication.presentation.RegistrationScreen
import com.android.darknesshabittracker.authentication.presentation.OptionButtons
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
class MainActivity : ComponentActivity() {

    private val navigation = Navigation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            navigation.AppNavigation(context = this)
        }
    }



}

