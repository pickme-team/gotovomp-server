package com.ligon.deeznuts

import com.ligon.deeznuts.tables.Recipes
import com.ligon.deeznuts.tables.Tags
import com.ligon.deeznuts.tables.Users
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    Database.connect(
        url = environment.config.property("database.url").getString(),
        user = environment.config.property("database.user").getString(),
        password = environment.config.property("database.password").getString(),
    )

    transaction {
        SchemaUtils.create(Recipes, Tags, Users)
    }
}
