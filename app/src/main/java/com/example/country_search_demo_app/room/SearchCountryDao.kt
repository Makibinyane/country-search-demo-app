package com.example.country_search_demo_app.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.country_search_demo_app.model.CountryDetailsResponse

@Dao
interface SearchCountryDao {

    @Query("SELECT * FROM countries")
    fun getAllCountries() : LiveData<List<CountryDetailsResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countries: List<CountryDetailsResponse>)

    @Query("DELETE FROM countries")
    suspend fun deleteAll()
}