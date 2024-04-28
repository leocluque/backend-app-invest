package com.example.util

import com.google.gson.*
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateAdapter : JsonSerializer<Gson> {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE

    override fun serialize(p0: Gson?, p1: Type?, p2: JsonSerializationContext?): JsonElement {
        val localDate = p0 as LocalDate
        return JsonPrimitive(formatter.format(localDate))
    }

}