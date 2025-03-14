package com.ligon.deeznuts

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    connectToDatabase()
    
    configureDI()
    configureSecurity()
    configureHTTP()
    configureMonitoring()
    configureRouting()
    configureExceptions()
    configureValidation()
}

fun Application.connectToDatabase() {
    Database.connect(
        url = environment.config.property("database.url").getString(),
        user = environment.config.property("database.user").getString(),
        password = environment.config.property("database.password").getString(),
    )
}
