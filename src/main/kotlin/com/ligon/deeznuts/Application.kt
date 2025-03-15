package com.ligon.deeznuts

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDatabase()
    configureDI()
    configureSecurity()
    configureHTTP()
    configureMonitoring()
    configureRouting()
    configureExceptions()
    configureValidation()
}
