package com.example.electronicwalletmoneypay.presentation.scanner

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.electronicwalletmoneypay.databinding.ActivityScannerBinding



class ScannerActivity : AppCompatActivity() {
    lateinit var binding: ActivityScannerBinding
    private lateinit var codeScanner: CodeScanner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scannerQrCode = binding.scannerQrcode
        codeScanner = CodeScanner(this, scannerQrCode)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false
        codeScanner.decodeCallback = DecodeCallback { result ->
            this.runOnUiThread {
                Toast.makeText(
                    this, "Scan result: ${result.text}", Toast.LENGTH_LONG
                ).show()
            }
        }
        codeScanner.errorCallback = ErrorCallback { result ->
            this.runOnUiThread {
                Toast.makeText(
                   this, "Camera initialization error: ${result.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        scannerQrCode.setOnClickListener {
            codeScanner.startPreview()
            checkPermission(android.Manifest.permission.CAMERA,200)
        }

    }
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
    fun checkPermission(permission:String, reqCode : Int)
    {
        if (ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED  )
        {
            ActivityCompat.requestPermissions(this, arrayOf(permission),reqCode)
        }
    }
    }
