package com.ligon.deeznuts.models.requests

import io.ktor.server.plugins.requestvalidation.*

interface Validatable {
    fun validate(): ValidationResult
}
