package com.android.darknesshabittracker.authentication.domain.use_case

import com.android.darknesshabittracker.authentication.domain.AuthRepository
import com.android.darknesshabittracker.authentication.domain.RegistrationCallback

class RegisterUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(email: String, password: String, callback: RegistrationCallback) {
        authRepository.register(email, password, callback)
    }
}