package com.ligon.deeznuts.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class User(
    val id: Long = 0,
    val username: String,
    val firstName: String?,
    val lastName: String?,
    val phoneNumber: String,
    @Transient
    val password: String = "",
)
