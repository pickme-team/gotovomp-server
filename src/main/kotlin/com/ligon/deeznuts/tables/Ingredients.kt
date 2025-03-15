package com.ligon.deeznuts.tables

import org.jetbrains.exposed.dao.id.LongIdTable

object Ingredients : LongIdTable() {
    val name = text("name").uniqueIndex()
    val category = text("category").nullable()
}
