package com.example.electronicwalletmoneypay.presentation

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.electronicwalletmoneypay.presentation.util.loadLocale

open class BaseActivity: AppCompatActivity() {

    var clickBackNumber = 0

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        loadLocale()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.loadLocale())
    }
}