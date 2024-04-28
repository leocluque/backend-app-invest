package com.example.routes

import com.example.data.response.ProductStatus
import com.example.data.response.ProductsResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listProducts() {
    get("listProducts") {

        val products = listOf(
            ProductsResponse(
                productName = "Produto XPTO1",
                status = ProductStatus.AVAILABLE
            ),
            ProductsResponse(
                productName = "Produto XPTO2",
                status = ProductStatus.AVAILABLE
            ),
            ProductsResponse(
                productName = "Produto XPTO3",
                status = ProductStatus.NOT_AVAILABLE
            ),
            ProductsResponse(
                productName = "Produto XPTO4",
                status = ProductStatus.NOT_AVAILABLE
            )
        )
        call.respond(HttpStatusCode.OK, products)
    }
}


fun Route.createProductAlert() {
    get("createProductAlert") {
        call.respond(HttpStatusCode.OK)
    }
}