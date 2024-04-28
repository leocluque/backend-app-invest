package com.example.routes

import com.example.data.repository.ProductAlertDataSource
import com.example.data.request.CreateProductAlertRequest
import com.example.data.request.toProduct
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listProducts(
    productAlertDataSource: ProductAlertDataSource
) {
    get("listProducts") {
        call.respond(HttpStatusCode.OK, productAlertDataSource.getAllProducts())
    }
}


fun Route.createProductAlert(
    productAlertDataSource: ProductAlertDataSource
) {
    post("createProductAlert") {
        val request =
            kotlin.runCatching { call.receiveNullable<CreateProductAlertRequest>() }.getOrNull() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

        val product = productAlertDataSource.insertNewAlert(request.toProduct())

        if (!product) {
            call.respond(HttpStatusCode.Conflict)
            return@post
        }
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.updateProductAlert(
    productAlertDataSource: ProductAlertDataSource
) {
    post("updateProductAlert") {
        val request =
            kotlin.runCatching { call.receiveNullable<CreateProductAlertRequest>() }.getOrNull() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

        val product = productAlertDataSource.updateAlert(request)

        if (!product) {
            call.respond(HttpStatusCode.Conflict)
            return@post
        }
        call.respond(HttpStatusCode.OK)
    }
}


fun Route.deleteProductAlert(
    productAlertDataSource: ProductAlertDataSource
) {
    post("deleteProductAlert") {
        val request =
            kotlin.runCatching { call.receiveNullable<CreateProductAlertRequest>() }.getOrNull() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

        val product = productAlertDataSource.deleteAlert(request.id.toString())

        if (!product) {
            call.respond(HttpStatusCode.Conflict)
            return@post
        }
        call.respond(HttpStatusCode.OK)
    }
}