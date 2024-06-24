package com.example.electronicwalletmoneypay.presentation.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.electronicwalletmoneypay.databinding.ActivitySettingBinding
import com.example.electronicwalletmoneypay.presentation.select_language.LanguageActivity

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLanguage.setOnClickListener {
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }
        binding.backSetting.setOnClickListener {
            finish()
        }

    }
}