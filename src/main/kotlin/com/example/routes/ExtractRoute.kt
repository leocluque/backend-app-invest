package com.example.routes

import com.example.data.response.ExtractResponse
import com.example.data.response.TransactionType
import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getExtract() {
    get("getExtract") {
        val transactions = listOf(
            ExtractResponse("TRX001", "2024-04-01", 3000.0, TransactionType.INCOME, 3000.0),
            ExtractResponse("TRX002", "2024-04-05", 1000.0, TransactionType.EXPENSE, 2000.0),
            ExtractResponse("TRX003", "2024-04-10", 250.0, TransactionType.EXPENSE, 1750.0),
            ExtractResponse("TRX004", "2024-04-15", 50.0, TransactionType.EXPENSE, 1700.0),
            ExtractResponse("TRX005", "2024-04-20", 200.0, TransactionType.INCOME, 1900.0),
            ExtractResponse("TRX006", "2024-04-25", 80.0, TransactionType.EXPENSE, 1820.0)
        )
        val gson = Gson()
        val transactionsJson = gson.toJson(transactions)

        call.respond(HttpStatusCode.OK, transactionsJson)
    }
}