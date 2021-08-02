package com.example.country_search_demo_app

import android.app.Application
import com.example.country_search_demo_app.di.*
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@HiltAndroidApp
class App : Application()