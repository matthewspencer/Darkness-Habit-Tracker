package com.android.darknesshabittracker.authentication.domain

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    fun register(email: String, password: String, callback: RegistrationCallback)
    fun login(email: String, password: String, callback: RegistrationCallback)
}