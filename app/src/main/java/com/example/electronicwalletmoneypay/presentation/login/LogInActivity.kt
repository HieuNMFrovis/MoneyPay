package com.example.electronicwalletmoneypay.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.electronicwalletmoneypay.MainActivity
import com.example.electronicwalletmoneypay.databinding.ActivityLogInBinding
import com.example.electronicwalletmoneypay.presentation.signup.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.edtLogin.setOnClickListener {
            val email = binding.EditTextTk.text.toString()
            val pass = binding.Password.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        handleSignInError(it.exception)

                    }
                }
            } else {
                Toast.makeText(this, "Không Được Để Trống !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun handleSignInError(exception: Exception?) {
        when (exception) {
            is FirebaseAuthInvalidUserException -> {
                Toast.makeText(this, "Tài khoản không tồn tại. Vui lòng kiểm tra lại.", Toast.LENGTH_SHORT).show()
            }
            is FirebaseAuthInvalidCredentialsException -> {
                Toast.makeText(this, "Mật khẩu không đúng. Vui lòng kiểm tra lại.", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Đăng nhập thất bại: ${exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}