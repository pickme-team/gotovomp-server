package com.ligon.deeznuts.tables

import org.jetbrains.exposed.dao.id.LongIdTable

object Tags : LongIdTable() {
    val tag = text("tag")
    val recipe = reference("recipe", Recipes)
}
