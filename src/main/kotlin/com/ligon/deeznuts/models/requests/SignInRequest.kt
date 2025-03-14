package com.ligon.deeznuts.models.requests

import io.ktor.server.plugins.requestvalidation.*
import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(val usernameOrEmail: String, val password: String) : Validatable {
    override fun validate(): ValidationResult {
        if (usernameOrEmail.isBlank() || password.isBlank()) {
            return ValidationResult.Invalid("wat")
        }

        return ValidationResult.Valid
    }
}
