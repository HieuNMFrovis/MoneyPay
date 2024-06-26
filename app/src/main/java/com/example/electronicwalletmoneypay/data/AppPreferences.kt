package com.example.electronicwalletmoneypay.data

import android.content.Context
import android.content.SharedPreferences
import com.example.electronicwalletmoneypay.helper.JsonHelper
import com.example.electronicwalletmoneypay.presentation.select_language.LanguageEnum
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.booleanPreference
import jp.takuji31.koreference.stringPreference

class AppPreferences(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_LANGUAGE = "language"
    }

    fun getLanguage(): LanguageEnum? {
        val languageCode = preferences.getString(KEY_LANGUAGE, null)
        return languageCode?.let { LanguageEnum.fromCode(it) }
    }

    fun setLanguage(language: LanguageEnum) {
        preferences.edit().putString(KEY_LANGUAGE, language.code).apply()
    }

    fun isFirstOpenApp(): Boolean {
        // Implement this function based on your requirement
        return preferences.getBoolean("first_open", true)
    }
}
