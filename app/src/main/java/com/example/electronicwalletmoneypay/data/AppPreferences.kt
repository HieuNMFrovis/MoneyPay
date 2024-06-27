package com.example.electronicwalletmoneypay.data

import android.content.Context
import android.content.SharedPreferences
import com.example.electronicwalletmoneypay.helper.JsonHelper
import com.example.electronicwalletmoneypay.presentation.select_language.LanguageEnum
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.booleanPreference
import jp.takuji31.koreference.stringPreference
import timber.log.Timber

class AppPreferences(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_LANGUAGE = "language"
        private const val KEY_FIRST_OPEN = "first_open"
    }

    fun setLanguage(language: LanguageEnum) {
        preferences.edit().putString(KEY_LANGUAGE, language.code).apply()
        Timber.d("Language set to: ${language.code}")
    }

    fun getLanguage(): LanguageEnum? {
        val languageCode = preferences.getString(KEY_LANGUAGE, null)
        Timber.d("Retrieved language code: $languageCode")
        return languageCode?.let { LanguageEnum.fromCode(it) }
    }


    fun isFirstOpenApp(): Boolean {
        return preferences.getBoolean(KEY_FIRST_OPEN, true)
    }

    fun setFirstOpenApp(firstOpen: Boolean) {
        preferences.edit().putBoolean(KEY_FIRST_OPEN, firstOpen).apply()
    }
}
