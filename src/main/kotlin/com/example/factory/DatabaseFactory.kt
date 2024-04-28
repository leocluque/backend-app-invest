package com.example.factory

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class DatabaseFactory {

    fun initConnectionDb(): CoroutineDatabase {
        val mongoPw = System.getenv("MONGO_PW")
        val dbName = "severino-app"
        return KMongo.createClient(
            connectionString = "mongodb+srv://lekogatinho2:$mongoPw@cluster0.geykp5u.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
        ).coroutine.getDatabase(dbName)
    }
}