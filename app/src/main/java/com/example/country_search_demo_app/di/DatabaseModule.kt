package com.example.country_search_demo_app.di

import android.content.Context
import com.example.country_search_demo_app.room.SearchCountryDao
import com.example.country_search_demo_app.room.SearchCountryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideSearchCountryDatabase(@ApplicationContext context: Context): SearchCountryDatabase {
        return SearchCountryDatabase.getInstance(context)
    }

    @Provides
    fun provideSearchCountryDao(searchCountryDatabase: SearchCountryDatabase): SearchCountryDao {
        return searchCountryDatabase.searchCountryDao()
    }

}