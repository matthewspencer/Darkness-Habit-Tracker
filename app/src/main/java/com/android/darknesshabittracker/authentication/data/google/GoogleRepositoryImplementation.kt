package com.android.darknesshabittracker.authentication.data.google

import com.android.darknesshabittracker.authentication.domain.AuthRepository
import com.android.darknesshabittracker.authentication.domain.RegistrationCallback
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class GoogleRepositoryImplementation @Inject constructor(
    private val auth: FirebaseAuth
): AuthRepository {
    override fun register(email: String, password: String, callback: RegistrationCallback) {
        TODO("Not yet implemented")
    }

    override fun login(email: String, password: String, callback: RegistrationCallback) {
        TODO("Not yet implemented")
    }
}