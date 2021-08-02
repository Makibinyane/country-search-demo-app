package com.example.country_search_demo_app.util.converters

import androidx.room.TypeConverter
import com.example.country_search_demo_app.model.Language
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LanguageTypeConverter {
    @TypeConverter
    fun stringToLanguages(json: String): Language {
        val gson = Gson()
        val type = object : TypeToken<Language>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun languagesToString(list: Language): String {
        val gson = Gson()
        val type = object : TypeToken<Language>() {}.type
        return gson.toJson(list, type)
    }
}