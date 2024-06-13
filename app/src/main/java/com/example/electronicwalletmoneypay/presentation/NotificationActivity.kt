package com.example.electronicwalletmoneypay.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.electronicwalletmoneypay.MainActivity
import com.example.electronicwalletmoneypay.R
import com.example.electronicwalletmoneypay.databinding.ActivityNotificationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnavigation)
        bottomNavigationView.selectedItemId = R.id.navigation_notifications
        bottomNavigationView.setOnItemSelectedListener { it ->
            when (it.itemId){
                R.id.navigation_home ->{
                    startActivity(Intent(this, MainActivity::class.java))
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_transactionhistory->{
                    startActivity(Intent(this,TransactionHistoryActivity::class.java))
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_notifications->
                    return@setOnItemSelectedListener true
                R.id.navigation_profile->{
                    startActivity(Intent(this,ProfileActivity::class.java))
                    return@setOnItemSelectedListener  true
                }
                else -> false
            }
        }

    }
}