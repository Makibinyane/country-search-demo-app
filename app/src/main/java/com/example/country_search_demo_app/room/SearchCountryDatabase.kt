package com.example.country_search_demo_app.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.country_search_demo_app.model.*
import com.example.country_search_demo_app.util.*
import com.example.country_search_demo_app.util.converters.*

@Database(
    entities = [CountryDetailsResponse::class, Currency::class, Language::class,
        RegionalBloc::class, Translations::class], version = 1, exportSchema = false
)

@TypeConverters(
    Converters::class,
    LanguageTypeConverter::class,
    RegionalBlocConverter::class,
    CurrencyConverter::class,
    TranslationsConverter::class)

abstract class SearchCountryDatabase : RoomDatabase() {
    abstract fun searchCountryDao(): SearchCountryDao

    companion object {

        @Volatile
        private var INSTANCE: SearchCountryDatabase? = null

        fun getInstance(context: Context): SearchCountryDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SearchCountryDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}