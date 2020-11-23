package com.codechallenge.nytimes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NYTApplication: Application()
{
    override fun onCreate()
    {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@NYTApplication)
            modules(listOf(KoinModules.modules))
        }
    }
}