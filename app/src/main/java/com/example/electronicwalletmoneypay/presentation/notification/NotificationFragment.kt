package com.example.electronicwalletmoneypay.presentation.notification

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.electronicwalletmoneypay.MainActivity
import com.example.electronicwalletmoneypay.R
import com.example.electronicwalletmoneypay.databinding.FragmentNotificationBinding
import com.example.electronicwalletmoneypay.databinding.FragmentProfileBinding
import com.example.electronicwalletmoneypay.presentation.setting.SettingActivity


class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backNotification.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
    }
}