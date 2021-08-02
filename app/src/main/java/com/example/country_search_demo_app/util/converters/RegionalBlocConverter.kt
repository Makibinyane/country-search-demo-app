package com.example.country_search_demo_app.util.converters

import androidx.room.TypeConverter
import com.example.country_search_demo_app.model.RegionalBloc
import com.example.country_search_demo_app.model.Translations
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RegionalBlocConverter {
    @TypeConverter
    fun stringToRegionalBloc(json: String): RegionalBloc? {
        val gson = Gson()
        val type = object : TypeToken<RegionalBloc>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun regionalBlocToString(regionalBloc: RegionalBloc): String {
        val gson = Gson()
        val type = object : TypeToken<RegionalBloc>() {}.type
        return gson.toJson(regionalBloc, type)
    }
}