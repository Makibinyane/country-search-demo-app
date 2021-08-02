package com.example.country_search_demo_app.util.converters

import androidx.room.TypeConverter
import com.example.country_search_demo_app.model.CountryDetailsResponse
import com.example.country_search_demo_app.model.Currency
import com.example.country_search_demo_app.model.Language
import com.example.country_search_demo_app.model.RegionalBloc
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToString(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromCurrency(value: String): List<Currency> {
        val listType = object : TypeToken<List<Currency>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToCurrency(list: List<Currency>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromLanguage(value: String): List<Language> {
        val listType = object : TypeToken<List<Language>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToLanguage(list: List<Language>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromRegionalBloc(value: String): List<RegionalBloc> {
        val listType = object : TypeToken<List<RegionalBloc>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToRegionalBloc(list: List<RegionalBloc>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromDouble(value: String): List<Double> {
        val listType = object : TypeToken<List<Double>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToDouble(list: List<Double>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromAnyToString(value: Object?): String? {
        return value?.toString()
    }

    val gson = Gson()

    @TypeConverter
    fun recipeToString(recipe: CountryDetailsResponse): String {
        return gson.toJson(recipe)
    }

    @TypeConverter
    fun stringToRecipe(recipeString: String): CountryDetailsResponse {
        val objectType = object : TypeToken<CountryDetailsResponse>() {}.type
        return gson.fromJson(recipeString, objectType)
    }


}