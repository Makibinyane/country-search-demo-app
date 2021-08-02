package com.example.country_search_demo_app.di

import com.example.country_search_demo_app.service.SearchCountryService
import com.example.country_search_demo_app.service.SearchCountryServiceClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideSearchCountryService(): SearchCountryService {
        return SearchCountryServiceClient.create()
    }
}
