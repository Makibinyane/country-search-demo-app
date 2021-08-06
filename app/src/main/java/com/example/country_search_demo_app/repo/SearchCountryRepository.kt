package com.example.country_search_demo_app.repo

import android.util.Log
import com.example.country_search_demo_app.room.SearchCountryDao
import com.example.country_search_demo_app.service.SearchCountryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchCountryRepository @Inject constructor(
    private val service: SearchCountryService,
    private val dao: SearchCountryDao
) {

    suspend fun getCountryDetailsByName(countryName: String) {
        withContext(Dispatchers.IO) {
            val response = service.getCountryDetailsByName(countryName)
            if (response.isSuccessful) {

                response.body()?.let {
                    Log.d("HELLO", it.toString())
                    dao.insertAll(it)
                }
            }
        }
    }

    val data = dao.getAllCountries()

}
