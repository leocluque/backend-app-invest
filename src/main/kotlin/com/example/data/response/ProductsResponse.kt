package com.example.data.response

data class ProductsResponse(
    val productName: String,
    val status: ProductStatus
)

enum class ProductStatus {
    AVAILABLE,
    NOT_AVAILABLE
}