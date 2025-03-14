package com.ligon.deeznuts.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int = 0,
    val username: String,
    val email: String,
    val password: String
)
