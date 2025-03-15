package com.ligon.deeznuts.tables

import org.jetbrains.exposed.dao.id.LongIdTable

object Users : LongIdTable() {
    val username = text("username").uniqueIndex()
    val firstName = text("first_name").nullable()
    val lastName = text("last_name").nullable()
    val phoneNumber = text("phone_number")
    val password = text("password")
}
