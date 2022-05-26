package com.capstonebangkit.skin_diagnosis_app.ui.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}