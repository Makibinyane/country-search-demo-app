package com.example.country_search_demo_app.util.converters

import androidx.room.TypeConverter
import com.example.country_search_demo_app.model.Currency
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CurrencyConverter {
    @TypeConverter
    fun stringToCurrency(json: String): Currency? {
        val gson = Gson()
        val type = object : TypeToken<Currency>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun currencyToString(currency: Currency): String {
        val gson = Gson()
        val type = object : TypeToken<Currency>() {}.type
        return gson.toJson(currency, type)
    }
}