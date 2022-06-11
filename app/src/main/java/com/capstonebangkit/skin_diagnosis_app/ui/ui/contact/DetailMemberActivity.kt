package com.capstonebangkit.skin_diagnosis_app.ui.ui.contact

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.capstonebangkit.skin_diagnosis_app.R

class DetailMemberActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_NOHP = "extra_nohp"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_member)
        setTitle(getString(R.string.detail_member))

        val tvNama: TextView = findViewById(R.id.edt_text_name_member)
        val tvEmail : TextView = findViewById(R.id.edt_text_email_member)
        val photo : ImageView = findViewById(R.id.edt_text_image_member)
        val tvPhone : TextView = findViewById(R.id.edt_text_phone_number_member)

        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val bundle = intent.extras
        val phone = intent.getStringExtra(EXTRA_NOHP)

        val names = name
        val emails = email
        val phones = phone
        if (bundle != null) {
            val imagevalue = bundle.getInt("image")
            photo.setImageResource(imagevalue);
        }

        tvNama.text = names
        tvEmail.text = emails
        tvPhone.text = phones


    }
}