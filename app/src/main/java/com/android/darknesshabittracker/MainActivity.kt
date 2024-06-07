package com.android.darknesshabittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.darknesshabittracker.Navigation.Navigation

class MainActivity : ComponentActivity() {

    private val navigation = Navigation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            navigation.AppNavigation(context = this)
        }
    }



}

