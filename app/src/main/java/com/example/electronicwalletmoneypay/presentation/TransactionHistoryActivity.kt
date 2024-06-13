package com.example.electronicwalletmoneypay.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.electronicwalletmoneypay.MainActivity
import com.example.electronicwalletmoneypay.R
import com.example.electronicwalletmoneypay.databinding.ActivityTransactionHistoryBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TransactionHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransactionHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnavigation)
        bottomNavigationView.selectedItemId = R.id.navigation_transactionhistory
        bottomNavigationView.setOnItemSelectedListener { it ->
            when (it.itemId){
                R.id.navigation_home ->{
                    startActivity(Intent(this, MainActivity::class.java))
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_transactionhistory->
                    return@setOnItemSelectedListener true

                R.id.navigation_notifications->{
                    startActivity(Intent(this,NotificationActivity::class.java))
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_profile->{
                    startActivity(Intent(this,ProfileActivity::class.java))
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }
    }


}