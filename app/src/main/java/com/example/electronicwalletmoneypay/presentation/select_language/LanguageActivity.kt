package com.example.electronicwalletmoneypay.presentation.select_language

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.electronicwalletmoneypay.MainActivity

import com.example.electronicwalletmoneypay.data.AppPreferences
import com.example.electronicwalletmoneypay.databinding.ActivityLanguageBinding
import com.example.electronicwalletmoneypay.presentation.BaseActivity
import com.example.electronicwalletmoneypay.presentation.util.setLocale
import org.koin.android.ext.android.inject
import timber.log.Timber
import java.util.Locale



class LanguageActivity : BaseActivity() {
    private lateinit var binding: ActivityLanguageBinding
    private lateinit var languageAdapter: LanguageAdapter
    private lateinit var languages: MutableList<LanguageEnum>
    private val spref: AppPreferences by inject()
    private var fromSetting: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        fromSetting = intent.getBooleanExtra("fromSetting", false)
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()

    }

    private fun setUpView() {
        val locale = getCurrentLocale(this)
        val systemLanguage = if (locale != null) LanguageEnum.fromCode(locale.language) else null

        languages = LanguageEnum.values().toMutableList()

        val selectedLanguage = spref.getLanguage()

        Timber.tag("SelectLanguageActivity").d("selectedLanguage: $selectedLanguage")

        if (selectedLanguage == null) {
            if (languages.map { it.code }.contains(locale?.language)) {
                languages.remove(systemLanguage)
                languages.add(0, systemLanguage!!)
            }
        }

        languageAdapter = LanguageAdapter(
            this, this::onLanguageChanged, languages, selectedLanguage
        )

        binding.languageList.apply {
            layoutManager = LinearLayoutManager(this@LanguageActivity)
            adapter = languageAdapter
        }
        binding.btnAcceptLanguage.setOnClickListener {
            handleClickDone()
        }

        if (!fromSetting) {
            binding.backLanguage.visibility =  View.INVISIBLE
        }

        binding.backLanguage.setOnClickListener {
            finish()
        }

        binding.btnAcceptLanguage.isVisible = !fromSetting
        binding.backLanguage.isVisible = true

    }

    private fun handleClickDone() {
        setLocale(languageAdapter.currentLanguage)
        if (!fromSetting) {
            if (spref.isFirstOpenApp()) {
                startActivity(Intent(this@LanguageActivity, MainActivity::class.java))
            } else {
                finish()
            }
        }

    }

    private fun onLanguageChanged(language: LanguageEnum, index: Int) {
        languageAdapter.updateCurrentLanguage(language, index)
    }

    private fun getCurrentLocale(context: Context): Locale? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.resources.configuration.locales.get(0)
        } else {
            context.resources.configuration.locale
        }

    }

}

