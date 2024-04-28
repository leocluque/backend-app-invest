package com.example.plugins

import com.example.util.LocalDateAdapter
import io.ktor.serialization.gson.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.time.LocalDate

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
            registerTypeAdapter(LocalDate::class.java, LocalDateAdapter())
        }
        json()
    }
    routing {
        get("/json/gson") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
    }
}
