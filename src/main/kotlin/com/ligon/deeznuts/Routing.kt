package com.ligon.deeznuts

import com.ligon.deeznuts.modules.authModule
import com.ligon.deeznuts.modules.pingModule
import com.ligon.deeznuts.modules.userModule
import io.ktor.server.application.*

fun Application.configureRouting() {
    pingModule()
    userModule()
    authModule()
}
