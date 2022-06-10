package com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Upload

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityUploadBinding
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Camera.CameraActivity
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Deteksi.ResultScanNormal
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Deteksi.ScanActivity
import com.capstonebangkit.skin_diagnosis_app.ui.DataApi.ApiConfig
import com.capstonebangkit.skin_diagnosis_app.ui.DataApi.res
import com.capstonebangkit.skin_diagnosis_app.ui.utils.reduceFileImage
import com.capstonebangkit.skin_diagnosis_app.ui.utils.uriToFile
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private var getFile: File? = null
    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGaleri.setOnClickListener {
            startGaleri()
        }

        binding.btnResult.setOnClickListener {
            startPrediction()
        }
        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }

    }
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    private fun startPrediction() {
        showLoading(true)
        if (getFile != null) {
            val file = reduceFileImage(getFile as File)
            val requestImageFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
                "file",
                file.name,
                requestImageFile
            )
            val client = ApiConfig.getApiServiceCamera().uploadimage(imageMultipart)
            client.enqueue(object :retrofit2.Callback<res>{
                override fun onResponse(
                    call: Call<res>,
                    response: Response<res>
                ) {
                    showLoading(false)
                    Toast.makeText(this@UploadActivity,getString(R.string.upload_sukses),
                        Toast.LENGTH_SHORT).show()
                    val prediction = response.body()?.Prediksi
                    val precentation = response.body()?.Presentase
                    if (prediction == "Normal"){
                        val intent = Intent(this@UploadActivity, ResultScanNormal::class.java)
                        intent.putExtra("prediksi","$prediction")
                        intent.putExtra("presentasi","$precentation")
                        intent.putExtra("picture", getFile!!.path.toString())
                        startActivity(intent)
                        finish()
                    }else{
                        val intent = Intent(this@UploadActivity, ScanActivity::class.java)
                        intent.putExtra("prediksi","$prediction")
                        intent.putExtra("presentasi","$precentation")
                        intent.putExtra("picture", getFile!!.path.toString())
                        startActivity(intent)
                        finish()
                    }
                }

                override fun onFailure(call: Call<res>, t: Throwable) {
                    showLoading(false)
                    Toast.makeText(this@UploadActivity,
                        getString(R.string.Upload_Gagal),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun startGaleri() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launcherIntentGallery.launch(chooser)
    }

    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val myFile = uriToFile(selectedImg, this)
            getFile = myFile
            binding.imageTampil.setImageURI(selectedImg)
        }
    }
}