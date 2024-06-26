package com.example.electronicwalletmoneypay.widget

import android.content.Context
import android.content.res.Configuration
import com.example.electronicwalletmoneypay.data.AppPreferences
import com.example.electronicwalletmoneypay.presentation.select_language.LanguageEnum
import java.util.Locale
import org.koin.core.context.GlobalContext.get


fun Context.setLocale(language: LanguageEnum) {
    val spref = get().get<AppPreferences>()
//    spref.saveLanguage(language)
    changeLang(language)
}

fun Context.loadLocale(): Context {
    val spref = get().get<AppPreferences>()
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