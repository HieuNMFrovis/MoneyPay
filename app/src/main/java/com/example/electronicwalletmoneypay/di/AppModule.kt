package com.example.electronicwalletmoneypay.di

import org.koin.dsl.module
import com.example.electronicwalletmoneypay.data.AppPreferences
import org.koin.android.ext.koin.androidContext

val appPreferencesModule = module {
    single { AppPreferences(androidContext()) }
}