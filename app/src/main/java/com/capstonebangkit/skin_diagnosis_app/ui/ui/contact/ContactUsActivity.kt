package com.capstonebangkit.skin_diagnosis_app.ui.ui.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityContactUsBinding

class ContactUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(getString(R.string.contact_us))
    }
}