package com.example.tubeskelompok5komc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up) // Pastikan layout ini ada

        // Inisialisasi EditText dan Button
        passwordInput = findViewById(R.id.et_password) // Pastikan ID ini sesuai dengan layout Anda
        confirmPasswordInput = findViewById(R.id.konfirm_password) // Pastikan ID ini sesuai dengan layout Anda


        // Mengatur listener untuk tombol Sign Up
        signUpButton.setOnClickListener {
            validatePasswords()
        }

        // Mengatur padding untuk edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun validatePasswords() {
        val password = passwordInput.text.toString()
        val confirmPassword = confirmPasswordInput.text.toString()

        if (password == confirmPassword) {
            // Passwords match, proceed with sign up
            Toast.makeText(this, "Passwords match!", Toast.LENGTH_SHORT).show()
            // Lanjutkan dengan proses pendaftaran
        } else {
            // Passwords do not match, show error
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
        }
    }
}
