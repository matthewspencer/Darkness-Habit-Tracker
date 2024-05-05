package com.android.darknesshabittracker.authentication.domain

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

private const val TAG = "Authentication"
class Authentication {
    
    private var auth = Firebase.auth
    fun registration(email: String, password: String, context: Context) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Log.d(TAG, "registration: SUCCESS")
                } else {
                    Log.d(TAG, "registration: FAILED")
                }
            }
    }

    fun login(email: String, password: String, context: Context) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "signed in successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "sign in failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun checkIfLoggedIn(context: Context) {
        val currentUser = auth.currentUser

        if (currentUser == null) {
            Toast.makeText(context, "Please, log into the system", Toast.LENGTH_SHORT).show()
        }
    }

    fun googleSignIn() {
        TODO()
    }

    fun logout() {
        TODO()
    }
}

/*
interface Authentication {
    fun createUserWithEmailAndPassword(email: String, password: String, context: Context)
    fun signInWithEmailAndPassword(email: String, password: String, context: Context)
}*/
