package com.ligon.deeznuts.models

import kotlinx.serialization.Serializable


@Serializable
data class Ingredient(
    val id: Long = 0,
    val name: String,
    val category: String?,
)
