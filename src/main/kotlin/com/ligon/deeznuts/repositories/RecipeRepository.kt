package com.ligon.deeznuts.repositories

import com.ligon.deeznuts.models.Recipe
import com.ligon.deeznuts.models.dao.RecipeDao
import com.ligon.deeznuts.tables.Recipes
import org.jetbrains.exposed.dao.with

class RecipeRepository {
    suspend fun getById(id: Long): Recipe? = dbQuery {
        RecipeDao.find { Recipes.id eq id }
            .with(RecipeDao::author, RecipeDao::tags)
            .singleOrNull()
            ?.toRecipe()
    }
}
