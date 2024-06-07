package com.android.darknesshabittracker.authentication.data.email_password

import com.android.darknesshabittracker.authentication.domain.AuthRepository
import com.android.darknesshabittracker.authentication.domain.RegistrationCallback
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class EmailPasswordRepositoryImplementation @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override fun register(email: String, password: String, callback: RegistrationCallback) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback.onSuccess(auth.currentUser)
                } else {
                    callback.onFailed("Registration failed")
                }
            }
    }

    override fun login(email: String, password: String, callback: RegistrationCallback) {

    }
}