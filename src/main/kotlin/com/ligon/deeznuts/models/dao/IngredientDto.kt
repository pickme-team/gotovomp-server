package com.ligon.deeznuts.models.dao

import com.ligon.deeznuts.tables.Ingredients
import com.ligon.deeznuts.tables.RecipeIngredients
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class IngredientDto(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<IngredientDto>(Ingredients)

    var name by Ingredients.name
    var category by Ingredients.category

    val recipeIngredients by RecipeIngredientDto referrersOn RecipeIngredients.ingredient
}
