package com.example.electronicwalletmoneypay.presentation.recharge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.electronicwalletmoneypay.R
import com.example.electronicwalletmoneypay.databinding.ActivityRechargeBinding

class RechargeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRechargeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRechargeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backRecharge.setOnClickListener {
            finish()
        }
    }
}