package com.capstonebangkit.skin_diagnosis_app.ui.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}