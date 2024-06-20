package com.example.electronicwalletmoneypay.data

import android.content.Context
import android.content.SharedPreferences
import com.example.electronicwalletmoneypay.helper.JsonHelper
import com.example.electronicwalletmoneypay.presentation.LanguageEnum
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.booleanPreference
import jp.takuji31.koreference.stringPreference

class AppPreferences private constructor(sharedPreferences: SharedPreferences) :
    KoreferenceModel(sharedPreferences) {
    constructor(context: Context) : this(
        context.applicationContext.getSharedPreferences(
            context.packageName, Context.MODE_PRIVATE
        )
    )
    private var language: String by stringPreference(default = "")
    private var firstOpenApp: Boolean by booleanPreference(default = false)
    fun saveLanguage(language: LanguageEnum) {
        this.language = JsonHelper.saveObject(language)
    }

    fun getLanguage(): LanguageEnum? {
        return JsonHelper.getObject(
            language, LanguageEnum::class.java
        )
    }
    fun isFirstOpenApp(): Boolean {
        return firstOpenApp
    }
}