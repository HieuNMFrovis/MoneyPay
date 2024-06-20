package com.example.electronicwalletmoneypay.helper

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FlowTypeAdapterFactory : TypeAdapterFactory {
    override fun <T : Any?> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        if (type.rawType == Flow::class.java) {
            return FlowTypeAdapter<T>() as TypeAdapter<T>
        }
        return null
    }
}

class FlowTypeAdapter<T> : TypeAdapter<Flow<T>>() {
    override fun write(out: JsonWriter?, value: Flow<T>?) {
        throw UnsupportedOperationException("Serialization of Flow is not supported")
    }

    override fun read(`in`: JsonReader): Flow<T> {
        val result = flow<T> {
            `in`.beginArray()
            while (`in`.hasNext()) {
                emit(`in`.nextString() as T)
            }
            `in`.endArray()
        }
        return result
    }
}