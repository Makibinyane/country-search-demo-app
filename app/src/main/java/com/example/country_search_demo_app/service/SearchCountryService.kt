package com.example.country_search_demo_app.service

import com.example.country_search_demo_app.model.CountryDetailsResponse
import com.example.country_search_demo_app.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchCountryService {

    @GET("name/{countryName}")
    suspend fun getCountryDetailsByName(@Path("countryName") countryName: String):
            Response<List<CountryDetailsResponse>>


}