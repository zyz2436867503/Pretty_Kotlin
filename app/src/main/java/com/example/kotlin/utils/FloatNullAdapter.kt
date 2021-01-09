package com.shop.utils

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.math.BigDecimal

class FloatNullAdapter: TypeAdapter<Float>() {
    override fun write(out: JsonWriter?, value: Float?) {
        out!!.value(value)
    }

    override fun read(`in`: JsonReader?): Float {
        if(`in`!!.peek() == JsonToken.STRING){
            `in`!!.skipValue()
            return -1f
        }
        var bigDecimal = BigDecimal(`in`.nextString())
        return bigDecimal.toFloat()
    }
}