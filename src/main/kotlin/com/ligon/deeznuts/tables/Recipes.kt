package com.ligon.deeznuts.tables

import org.jetbrains.exposed.dao.id.LongIdTable

object Recipes : LongIdTable() {
    val name = text("name").uniqueIndex()
    val author = reference("author", Users)
    val text = text("text").index()
}
