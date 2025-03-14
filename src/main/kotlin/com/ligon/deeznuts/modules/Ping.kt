package com.ligon.deeznuts.modules

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.pingModule() = routing {
    get("/ping") { call.respondText("Pong!") }
}
