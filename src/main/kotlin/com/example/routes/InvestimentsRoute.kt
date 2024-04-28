package com.example.routes

import com.example.data.response.ContractedProducts
import com.example.data.response.InvestmentsResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.random.Random

fun Route.myInvestments() {
    get("getInvestments") {

        val total = 160000.0
        val investmentFund = ContractedProducts(
            productName = "Fundos de investimentos",
            productValue = 150.00,
            totalInvested = 96000.0,
            color = generateHexColor()
        ).apply {
            percentage = calculatePercentage(totalInvested, total)
        }

        val titles = ContractedProducts(
            productName = "Tesouro Direto e Títulos",
            productValue = 150.00,
            totalInvested = 32000.00,
            color = generateHexColor()
        ).apply {
            percentage = calculatePercentage(totalInvested, total)
        }

        val actions = ContractedProducts(
            productName = "Ações",
            productValue = 150.00,
            totalInvested = 32000.00,
            color = generateHexColor()
        ).apply {
            percentage = calculatePercentage(totalInvested, total)
        }

        call.respond(
            HttpStatusCode.OK, InvestmentsResponse(
                totalInvested = 196000.00,
                contractedProducts = listOf(investmentFund, titles, actions)
            )
        )
    }
}

fun calculatePercentage(valorInvestido: Double, montanteTotal: Double): Double {
    return (valorInvestido / montanteTotal) * 100
}

fun generateHexColor(): String {
    val hexadecimalCharacters = "0123456789ABCDEF"
    var hexColor = "#"

    for (i in 1..6) {
        val randomIndex = Random.nextInt(0, hexadecimalCharacters.length)
        hexColor += hexadecimalCharacters[randomIndex]
    }

    return hexColor
}
