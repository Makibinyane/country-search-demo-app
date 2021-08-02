package com.example.country_search_demo_app.util.converters

import androidx.room.TypeConverter
import com.example.country_search_demo_app.model.Translations
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TranslationsConverter {
    @TypeConverter
    fun stringToTranslations(json: String): Translations? {
        val gson = Gson()
        val type = object : TypeToken<Translations>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun translationsToString(translations: Translations): String {
        val gson = Gson()
        val type = object : TypeToken<Translations>() {}.type
        return gson.toJson(translations, type)
    }
}