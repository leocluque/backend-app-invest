package com.example.data.repository

import com.example.data.response.ProductStatus
import com.example.data.response.ProductsResponse
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class ProductAlert(
    @BsonId
    val id: ObjectId = ObjectId(),
    val productName: String,
    val status: ProductStatus,
    val productValue: Double
)

fun ProductAlert.toProductResponse(): ProductsResponse {
    return ProductsResponse(
        id = id.toString(),
        productName = productName,
        status = status,
        productValue = productValue
    )
}