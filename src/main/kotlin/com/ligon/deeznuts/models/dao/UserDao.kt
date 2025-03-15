package com.ligon.deeznuts.models.dao

import com.ligon.deeznuts.models.User
import com.ligon.deeznuts.tables.Recipes
import com.ligon.deeznuts.tables.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDao(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserDao>(Users)

    var username by Users.username
    var firstName by Users.firstName
    var lastName by Users.lastName
    var phoneNumber by Users.phoneNumber
    var password by Users.password
    val recipes by RecipeDao referrersOn Recipes.author

    fun toUser() = User(
        id = id.value,
        username = username,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        password = password
    )
}
