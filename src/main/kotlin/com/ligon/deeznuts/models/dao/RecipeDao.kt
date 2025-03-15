package com.ligon.deeznuts.models.dao

import com.ligon.deeznuts.models.Recipe
import com.ligon.deeznuts.tables.Recipes
import com.ligon.deeznuts.tables.Tags
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class RecipeDao(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<RecipeDao>(Recipes)

    var name by Recipes.name
    var author by UserDao referencedOn Recipes.author
    var text by Recipes.text
    val tags by TagDao referrersOn Tags.recipe

    fun toRecipe() = Recipe(
        id = id.value,
        name = name,
        author = author.toUser(),
        text = text,
        tags = tags.map { it.tag },
        ingredients = listOf()
    )
}
