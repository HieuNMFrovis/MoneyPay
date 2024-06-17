package com.example.electronicwalletmoneypay.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.electronicwalletmoneypay.databinding.FragmentScannerBinding


class ScannerFragment : Fragment() {
    private var _binding: FragmentScannerBinding? = null
    private val binding get() = _binding!!
    private lateinit var codeScanner: CodeScanner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScannerBinding.inflate(inflater, container, false)
        return binding.root
        requestPermissionCamera()
    }
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
    private fun requestPermissionCamera() {
        val scannerQrCode = binding.scannerQrcode
        codeScanner = CodeScanner(requireContext(), scannerQrCode)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false
        codeScanner.decodeCallback = DecodeCallback { result ->
            requireActivity().runOnUiThread {
                Toast.makeText(requireActivity(), "Scan result: ${result.text}", Toast.LENGTH_LONG).show()
            }
        }
        codeScanner.errorCallback = ErrorCallback { result ->
            requireActivity().runOnUiThread {
                Toast.makeText(
                    requireActivity(), "Camera initialization error: ${result.message}", Toast.LENGTH_LONG
                ).show()
            }
        }
        scannerQrCode.setOnClickListener {
            codeScanner.startPreview()
        }
    }
}