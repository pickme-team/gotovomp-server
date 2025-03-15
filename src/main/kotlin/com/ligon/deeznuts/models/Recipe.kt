package com.ligon.deeznuts.models

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Long = 0,
    val name: String,
    val author: User,
    val text: String,
    val tags: List<String>,
    val ingredients: List<RecipeIngredient>
)
