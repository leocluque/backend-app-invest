package com.example.data.repository

import com.example.data.request.CreateProductAlertRequest
import com.example.data.response.ProductsResponse
import com.mongodb.BasicDBObject
import org.bson.types.ObjectId
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq


class MongoProductAlertDataSource(
    db: CoroutineDatabase
) : ProductAlertDataSource {

    private val product = db.getCollection<ProductAlert>()


    override suspend fun getAllProducts(): List<ProductsResponse> {
        return product.find().toList().map { it.toProductResponse() }
    }

    override suspend fun insertNewAlert(alert: ProductAlert): Boolean {
        return product.insertOne(alert).wasAcknowledged()
    }

    override suspend fun deleteAlert(id: String): Boolean {
        return product.deleteOne(ProductAlert::id eq ObjectId(id)).wasAcknowledged()
    }

    override suspend fun updateAlert(product: CreateProductAlertRequest): Boolean {
        val updateFields = BasicDBObject()
        updateFields.append("productName", product.productName)
        updateFields.append("status", product.status)
        updateFields.append("productValue", product.productValue)
        val setQuery = BasicDBObject()
        setQuery.append("${MongoOperator.set}", updateFields)
        return this.product.updateOne(ProductAlert::id eq ObjectId(product.id), setQuery).wasAcknowledged()
    }
}