package com.ligon.deeznuts.models.dao

import com.ligon.deeznuts.tables.RecipeIngredients
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class RecipeIngredientDto(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<RecipeIngredientDto>(RecipeIngredients)

    var recipe by RecipeDao referencedOn RecipeIngredients.recipe
    var ingredient by IngredientDto referencedOn RecipeIngredients.ingredient

    var quantityType by RecipeIngredients.quantityType
    var quantity by RecipeIngredients.quantity
    var additionalParameters by RecipeIngredients.additionalParameters
}
