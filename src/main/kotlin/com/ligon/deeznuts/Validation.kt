package com.ligon.deeznuts

import com.ligon.deeznuts.models.requests.Validatable
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*

fun Application.configureValidation() {
    install(RequestValidation) {
        validate<Validatable> {
            it.validate()
        }
    }
}
