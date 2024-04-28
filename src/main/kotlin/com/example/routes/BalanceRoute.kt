package com.example.routes

import com.example.data.response.BalanceResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getBalance() {
    get("getBalance") {
        call.respond(HttpStatusCode.OK, BalanceResponse(160000.00))
    }
}