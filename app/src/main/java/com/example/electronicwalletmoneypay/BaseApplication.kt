package com.example.electronicwalletmoneypay

import android.app.Application
import com.akexorcist.localizationactivity.BuildConfig
import com.example.electronicwalletmoneypay.di.appPreferencesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import timber.log.Timber


class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(androidContext = this@BaseApplication)
            modules(appPreferencesModule)
        }

    }
    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}