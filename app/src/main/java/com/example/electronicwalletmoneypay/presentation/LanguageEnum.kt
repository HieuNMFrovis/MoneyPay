package com.example.electronicwalletmoneypay.presentation

import com.example.electronicwalletmoneypay.R

enum class LanguageEnum(val title: String, val icon: Int, val code: String) {
    ENGLISH("English", R.drawable.ic_language_english, "en"),
    VietNam(
        "VietNam", R.drawable.ic_language_vietnam, "vn"
    );
    companion object {
        fun fromCode(code: String): LanguageEnum? {
            return values().find { it.code == code }
        }
    }
}