package com.ligon.deeznuts.modules

import com.ligon.deeznuts.models.requests.SignInRequest
import com.ligon.deeznuts.models.requests.SignUpRequest
import com.ligon.deeznuts.services.AuthService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.authModule() {
    val authService by inject<AuthService>()

    routing {
        route("/auth") {
            post("/signIn") {
                val req = call.receive<SignInRequest>()
                call.respond(authService.signIn(req))
            }
            post("/signUp") {
                val req = call.receive<SignUpRequest>()
                call.respond(authService.signUp(req))
            }
        }
    }
}

