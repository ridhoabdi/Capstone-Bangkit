package com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Deteksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityCameraBinding
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityScanBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class ScanActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_pred = "prediksi"
        const val EXTRA_prec = "presentasi"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
        val tvPredict: TextView = findViewById(R.id.predict)
        val tvPrecent: TextView = findViewById(R.id.precent)
//        getData()
        val hasilprediksi = intent.getStringExtra(EXTRA_pred)
        val hasilpresentase = intent.getStringExtra(EXTRA_prec)

        val text = "Prediksi : $hasilprediksi"
        val text2 = "Presentase: $hasilpresentase"

        tvPredict.text = text
        tvPrecent.text = text2
    }
}