package com.example.plugins

import com.example.data.repository.ProductAlertDataSource
import com.example.routes.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val productAlertDataSource: ProductAlertDataSource by inject()

    routing {
        getBalance()
        myInvestments()
        getExtract()
        listProducts(productAlertDataSource)
        createProductAlert(productAlertDataSource)
        updateProductAlert(productAlertDataSource)
        deleteProductAlert(productAlertDataSource)
    }
}
