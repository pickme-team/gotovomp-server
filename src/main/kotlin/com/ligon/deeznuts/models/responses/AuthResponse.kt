package com.ligon.deeznuts.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(val token: String)
