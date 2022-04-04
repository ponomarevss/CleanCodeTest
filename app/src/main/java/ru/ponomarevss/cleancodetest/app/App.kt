package ru.ponomarevss.cleancodetest.app

import android.app.Application
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.ponomarevss.cleancodetest.di.appModule
import ru.ponomarevss.cleancodetest.di.dataModule
import ru.ponomarevss.cleancodetest.di.domainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
//            androidLogger(Level.DEBUG)
            if (BuildConfig.DEBUG)
                androidLogger()

            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}