package com.example.electronicwalletmoneypay.presentation


import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.example.electronicwalletmoneypay.databinding.ActivityLanguageBinding

class LanguageActivity : LocalizationActivity() {
    private lateinit var binding: ActivityLanguageBinding

    private var languageAdapter: LanguageAdapter? = null

    private var currentLanguage: String = LanguageEnum.English.locate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onListenView()
    }

    private fun onListenView() {
        val currentLocate = getCurrentLanguage()
        languageAdapter = LanguageAdapter(
            onClickLanguageItem = {
                Toast.makeText(this, "On Click Language: $it", Toast.LENGTH_SHORT).show()
                currentLanguage = it.locate
            },
            currentLocate = currentLocate.toString(),
        )

        binding.btnAcceptLanguage.setOnClickListener {
            setLanguage(currentLanguage)
            finish()
        }
        binding.backLanguage.setOnClickListener {
            finish()
        }
        binding.languageList.layoutManager = LinearLayoutManager(this)
        binding.languageList.adapter = languageAdapter
    }
}