package com.ligon.deeznuts.models

import kotlinx.serialization.Serializable

@Serializable
data class RecipeIngredient(
    val ingredient: Ingredient,
    val quantityType: String?,
    val quantity: Double?,
    val additionalParameters: String?
)
