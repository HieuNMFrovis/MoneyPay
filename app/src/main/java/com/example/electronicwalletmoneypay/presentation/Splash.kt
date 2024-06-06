package com.example.electronicwalletmoneypay.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.electronicwalletmoneypay.MainActivity
import com.example.electronicwalletmoneypay.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}