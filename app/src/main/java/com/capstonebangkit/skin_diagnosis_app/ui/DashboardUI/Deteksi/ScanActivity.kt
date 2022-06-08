package com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Deteksi

import android.content.Intent
import android.graphics.BitmapFactory
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityCameraBinding
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityScanBinding
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.safeDeteksi.ChickenpoxActivity
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.safeDeteksi.ScabiesActivity
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.reflect.Array.getInt

class ScanActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_pred = "prediksi"
        const val EXTRA_prec = "presentasi"
        const val EXTRA_pict = "picture"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
        val tvPredict: TextView = findViewById(R.id.predict)
        val tvPrecent: TextView = findViewById(R.id.precent)
        val imgObat : ImageView = findViewById(R.id.imageObat)
        val btn : Button = findViewById(R.id.safePredict)


        val hasilprediksi = intent.getStringExtra(EXTRA_pred)
        val hasilpresentase = intent.getStringExtra(EXTRA_prec)
        val hasilGambar = intent.getStringExtra(EXTRA_pict)
        val result = BitmapFactory.decodeFile(hasilGambar)
        val text = "$hasilprediksi"
        val text2 = "$hasilpresentase"


        tvPredict.text = text
        tvPrecent.text = "$text2%"
        imgObat.setImageBitmap(result)

        btn.setOnClickListener {
            if (text == "Scabies"){
                val intent = Intent(this,ScabiesActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this,ChickenpoxActivity::class.java)
                startActivity(intent)
            }
        }
    }


}




