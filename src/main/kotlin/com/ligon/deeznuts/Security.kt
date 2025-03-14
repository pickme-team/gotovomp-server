package com.ligon.deeznuts

import com.ligon.deeznuts.services.JWTService
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureSecurity() {
    val jwtService by inject<JWTService>()

    authentication {
        jwtService.configureJWT(this)
    }
}

fun RoutingCall.userId() =
    principal<JWTPrincipal>()?.subject?.toInt() ?: throw Exception("userId called on an invalid or missing token")
