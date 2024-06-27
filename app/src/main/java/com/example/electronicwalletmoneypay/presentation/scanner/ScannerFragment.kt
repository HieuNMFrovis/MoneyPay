package com.example.electronicwalletmoneypay.presentation.scanner

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.electronicwalletmoneypay.R

import com.example.electronicwalletmoneypay.databinding.FragmentScannerBinding


class ScannerFragment : Fragment() {
    private var _binding: FragmentScannerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel = ViewModelProvider(this)[ScannerViewModel::class.java]
        _binding = FragmentScannerBinding.inflate(inflater, container, false)
        return binding.root
        val textView: TextView = binding.textScanner
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        context?.getColor(R.color.black)?.let {
            activity?.window?.statusBarColor = it
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        context?.getColor(R.color.MailColor)?.let {
            activity?.window?.statusBarColor = it
        }
        _binding = null
    }
}




