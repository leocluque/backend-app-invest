package com.example.data.request

import com.example.data.repository.ProductAlert
import com.example.data.response.ProductStatus

@kotlinx.serialization.Serializable
data class CreateProductAlertRequest(
    var id: String? = "",
    val productName: String,
    val status: ProductStatus,
    val productValue: Double
)

fun CreateProductAlertRequest.toProduct(): ProductAlert {
    return ProductAlert(
        productName = productName,
        status = status,
        productValue = productValue
    )
}
