package com.ligon.deeznuts.models.requests

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(val usernameOrPhoneNumber: String, val password: String)
