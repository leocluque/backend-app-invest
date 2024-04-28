package com.example.data.repository

import com.example.data.request.CreateProductAlertRequest
import com.example.data.response.ProductsResponse


interface ProductAlertDataSource {

    suspend fun getAllProducts(): List<ProductsResponse>
    suspend fun insertNewAlert(alert: ProductAlert): Boolean
    suspend fun deleteAlert(id: String): Boolean
    suspend fun updateAlert(product: CreateProductAlertRequest): Boolean
}