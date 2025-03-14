package com.ligon.deeznuts

import com.ligon.deeznuts.repositories.UserRepository
import com.ligon.deeznuts.services.AuthService
import com.ligon.deeznuts.services.JWTService
import com.ligon.deeznuts.services.UserService
import io.ktor.server.application.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDI() {
    val appModule = module {
        single { environment }

        singleOf(::UserRepository)

        singleOf(::JWTService)
        singleOf(::UserService)
        singleOf(::AuthService)
    }

    install(Koin) {
        slf4jLogger()

        modules(appModule)
    }
}
