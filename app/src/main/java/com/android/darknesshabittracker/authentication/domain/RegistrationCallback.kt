package com.android.darknesshabittracker.authentication.domain

import com.google.firebase.auth.FirebaseUser

interface RegistrationCallback {
    fun onSuccess(user: FirebaseUser?)
    fun onFailed(message: String)
}