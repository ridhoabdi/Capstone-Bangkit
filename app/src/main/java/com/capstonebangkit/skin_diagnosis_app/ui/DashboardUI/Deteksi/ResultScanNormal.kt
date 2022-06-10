package com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Deteksi

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Camera.CameraActivity

class ResultScanNormal : AppCompatActivity() {
    companion object {
        const val EXTRA_pred = "prediksi"
        const val EXTRA_prec = "presentasi"
        const val EXTRA_pict = "picture"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_scan_normal)
        val tvPredict: TextView = findViewById(R.id.predict)
        val tvPrecent: TextView = findViewById(R.id.precent)
        val imgObat : ImageView = findViewById(R.id.imageObat)
        val btn : Button = findViewById(R.id.safePredict)

        val hasilprediksi = intent.getStringExtra(ScanActivity.EXTRA_pred)
        val hasilpresentase = intent.getStringExtra(ScanActivity.EXTRA_prec)
        val hasilGambar = intent.getStringExtra(ScanActivity.EXTRA_pict)
        val result = BitmapFactory.decodeFile(hasilGambar)
        val text = "$hasilprediksi"
        val text2 = "$hasilpresentase"

        tvPredict.text = text
        tvPrecent.text = "$text2%"
        imgObat.setImageBitmap(result)

        btn.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            Toast.makeText(this, "Kulit Anda Normal", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}