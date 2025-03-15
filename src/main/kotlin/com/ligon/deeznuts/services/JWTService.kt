package com.ligon.deeznuts.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import java.time.Instant
import java.util.*

class JWTService(environment: ApplicationEnvironment) {
    private val jwtAudience = environment.config.property("jwt.audience").getString()
    private val jwtDomain = environment.config.property("jwt.domain").getString()
    private val jwtSecret = environment.config.property("jwt.secret").getString()

    fun generateToken(id: Long): String =
        JWT.create()
            .withAudience(jwtAudience)
            .withIssuer(jwtDomain)
            .withSubject(id.toString())
            .withIssuedAt(Date.from(Instant.now()))
            .withExpiresAt(Date.from(Instant.now().plusSeconds(60 * 60 * 24 * 30)))
            .sign(Algorithm.HMAC256(jwtSecret))

    fun configureJWT(config: AuthenticationConfig) = config.jwt {
        verifier(
            JWT
                .require(Algorithm.HMAC256(jwtSecret))
                .withAudience(jwtAudience)
                .withIssuer(jwtDomain)
                .build()
        )
        validate { credential ->
            if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
        }
    }
}
