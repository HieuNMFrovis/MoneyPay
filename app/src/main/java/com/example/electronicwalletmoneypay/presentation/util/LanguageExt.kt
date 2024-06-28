package com.example.electronicwalletmoneypay.presentation.util

import android.content.Context
import android.content.res.Configuration
import com.example.electronicwalletmoneypay.data.AppPreferences
import com.example.electronicwalletmoneypay.presentation.select_language.LanguageEnum
import org.koin.core.context.GlobalContext
import java.util.Locale

fun Context.setLocale(language: LanguageEnum) {
    val spref = GlobalContext.get().get<AppPreferences>()
    spref.saveLanguage(language)
    changeLang(language)
}

fun Context.loadLocale(): Context {
    val spref = GlobalContext.get().get<AppPreferences>()
    val language = spref.getLanguage()
    return changeLang(language)
}

fun Context.changeLang(language: LanguageEnum?): Context {
    if (language == null) return this

    val locale = Locale(language.code)
    Locale.setDefault(locale)

    val config = Configuration(this.resources.configuration)
    config.setLocale(locale)
    config.setLayoutDirection(locale)
    return this.createConfigurationContext(config)
}