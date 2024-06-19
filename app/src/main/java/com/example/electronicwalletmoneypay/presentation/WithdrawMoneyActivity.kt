package com.example.electronicwalletmoneypay.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.electronicwalletmoneypay.R
import com.example.electronicwalletmoneypay.databinding.ActivitySettingBinding
import com.example.electronicwalletmoneypay.databinding.ActivityWithdrawMoneyBinding

class WithdrawMoneyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWithdrawMoneyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWithdrawMoneyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backWithdrawMoney.setOnClickListener {
            finish()
        }
    }
}