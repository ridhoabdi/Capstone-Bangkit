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

    private lateinit var binding: ActivityScanBinding
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

//    private fun getData() {
//        val client = AsyncHttpClient()
//        val url = "http://192.168.0.117:5000/Upload"
//        client.post(url, object : AsyncHttpResponseHandler(){
//            override fun onSuccess(
//                statusCode: Int,
//                headers: Array<out Header>?,
//                responseBody: ByteArray?
//            ) {
//                val result = responseBody?.let { String(it) }
//                Log.d(TAG.toString(), result!!)
//                try {
//                    val responseObject = JSONObject(result)
//                    val quote = responseObject.getString("Prediksi")
//                    val author = responseObject.getString("Presentase")
//                    binding.predict.text = quote
//                    binding.precent.text = author
//                } catch (e: Exception) {
//                    Toast.makeText(this@ScanActivity, e.message, Toast.LENGTH_SHORT).show()
//                    e.printStackTrace()
//                }
//            }
//
//            override fun onFailure(
//                statusCode: Int,
//                headers: Array<out Header>?,
//                responseBody: ByteArray?,
//                error: Throwable?
//            ) {
//                val errorMessage = when (statusCode) {
//                    401 -> "$statusCode : Bad Request"
//                    403 -> "$statusCode : Forbidden"
//                    404 -> "$statusCode : Not Found"
//                    else -> "$statusCode : ${error!!.message}"
//                }
//                Toast.makeText(this@ScanActivity, errorMessage, Toast.LENGTH_SHORT).show()
//            }
//
//        })
//    }
}