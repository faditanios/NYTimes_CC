package com.codechallenge.nytimes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NYTApplication: Application()
{
    override fun onCreate()
    {
        super.onCreate()
        startKoin {
            androidContext(this@NYTApplication)
            modules(listOf(appModule))
        }
    }
}