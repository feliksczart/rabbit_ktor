package com.felikscoding.routes

import com.felikscoding.data.model.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://localhost:8100"
private const val BASE_URL_EMULATOR = "http://10.0.2.2:8100"
private const val BASE_URL_DEVICE = "http://192.168.1.101:8100"

private val rabbits = listOf(
    Rabbit("Carl", "A cute brown rabbit", "$BASE_URL_DEVICE/rabbits/rabbit1.jpg"),
    Rabbit("Emma", "Emma likes to eat apples", "$BASE_URL_DEVICE/rabbits/rabbit2.jpg"),
    Rabbit("Florian", "Florian is always hungry", "$BASE_URL_DEVICE/rabbits/rabbit3.jpg"),
    Rabbit("Federico", "Federico likes to climb mountains", "$BASE_URL_DEVICE/rabbits/rabbit4.jpg"),
    Rabbit("Gina", "Gina is a true beauty", "$BASE_URL_DEVICE/rabbits/rabbit5.jpg"),
)

fun Route.randomRabbit() {

    get("/randomrabbit") {
        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
        )
    }
}