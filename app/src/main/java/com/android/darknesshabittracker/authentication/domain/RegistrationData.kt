package com.android.darknesshabittracker.authentication.domain

data class RegistrationData(
    val userName: String,
    val email: String,
    val password: String,
    val confirmPassword: String
)