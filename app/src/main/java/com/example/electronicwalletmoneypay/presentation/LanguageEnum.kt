package com.example.electronicwalletmoneypay.presentation

import com.example.electronicwalletmoneypay.R

enum class LanguageEnum(val locate: String, val textId: Int, val imageId: Int) {
    Vietnam(
        locate = "vi", textId = R.string.Language_vietnam, imageId = R.drawable.ic_language_vietnam
    ),
    English(
        "en", textId = R.string.Language_english, imageId = R.drawable.ic_language_english
    )
}