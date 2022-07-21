package com.felikscoding

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.felikscoding.plugins.*

fun main() {
    embeddedServer(Netty, port = 8100, host = "0.0.0.0") {
        configureSerialization()
        configureMonitoring()
        configureRouting()
    }.start(wait = true)
}
