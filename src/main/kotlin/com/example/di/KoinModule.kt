package com.example.di

import com.example.data.repository.MongoProductAlertDataSource
import com.example.data.repository.ProductAlertDataSource
import com.example.factory.DatabaseFactory
import org.koin.dsl.module

val koinModule = module {
    single {
        DatabaseFactory().initConnectionDb()
    }
    single<ProductAlertDataSource> {
        MongoProductAlertDataSource(get())
    }
}