package com.ligon.deeznuts.tables

import com.ligon.deeznuts.models.QuantityType
import org.jetbrains.exposed.dao.id.LongIdTable

object RecipeIngredients : LongIdTable() {
    val recipe = reference("recipe", Recipes)
    val ingredient = reference("ingredient", Ingredients)
    val quantityType = enumeration<QuantityType>("quantity_type")
    val quantity = double("quantity").nullable()
    val additionalParameters = text("additional_parameters").nullable()
}
