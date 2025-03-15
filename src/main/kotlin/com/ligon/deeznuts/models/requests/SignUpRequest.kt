package com.ligon.deeznuts.models.requests

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val username: String,
    val firstName: String? = null,
    val lastName: String? = null,
    val phoneNumber: String,
    val password: String
)
