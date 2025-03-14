package com.ligon.deeznuts.modules

import com.ligon.deeznuts.services.UserService
import com.ligon.deeznuts.userId
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.userModule() {
    val userService by inject<UserService>()

    routing {
        route("/user") {
            authenticate {
                get("/me") {
                    call.respond(userService.findById(call.userId()))
                }
            }
        }
    }
}
