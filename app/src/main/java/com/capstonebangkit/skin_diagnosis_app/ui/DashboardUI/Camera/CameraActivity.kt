package com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Camera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityCameraBinding
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Deteksi.ScanActivity
import com.capstonebangkit.skin_diagnosis_app.ui.DataApi.ApiConfig
import com.capstonebangkit.skin_diagnosis_app.ui.response.ApiResponse
import com.capstonebangkit.skin_diagnosis_app.ui.utils.createTempFile
import com.capstonebangkit.skin_diagnosis_app.ui.utils.reduceFileImage
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File


class CameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding
    private var getFile: File? = null

    companion object {
//        const val CAMERA_X_RESULT = 200
//        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
//        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == REQUEST_CODE_PERMISSIONS) {
//            if (!allPermissionsGranted()) {
//                Toast.makeText(
//                    this,
//                    "Tidak mendapatkan permission.",
//                    Toast.LENGTH_SHORT
//                ).show()
//                finish()
//            }
//        }
//    }
//
//    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
//        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        if (!allPermissionsGranted()) {
//            ActivityCompat.requestPermissions(
//                this,
//                REQUIRED_PERMISSIONS,
//                REQUEST_CODE_PERMISSIONS
//            )
//        }
        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
        //action camera
        binding.cameraXButton.setOnClickListener { startCameraX() }
        //action posting
        binding.uploadButton.setOnClickListener { startPrediction() }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all{
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    //upload prediction
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
//            val data = requestImageFile
//            val client = OkHttpClient()
//            val request = Request.Builder().url("http://192.168.0.117:5000/")
//                .post(data)
//                .build();
//            client.newCall(request).enqueue(object :Callback {
//                override fun onFailure(call: okhttp3.Call, e: IOException) {
//                    e.printStackTrace()
//                }
//
//                override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
//                    if (response.isSuccessful) {
//                        Toast.makeText(this@CameraActivity,
//                            getString(R.string.upload_sukses),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        val intent = Intent(this@CameraActivity, ScanActivity::class.java)
//                        startActivity(intent)
//                        finish()
//                    } else {
//                        Toast.makeText(this@CameraActivity,
//                            getString(R.string.Upload_Gagal),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//
//            })
            val client = ApiConfig.getApiServiceCamera().uploadimage(imageMultipart)
            client.enqueue(object : retrofit2.Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    Toast.makeText(this@CameraActivity,getString(R.string.upload_sukses),
                        Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@CameraActivity, ScanActivity::class.java)
                        startActivity(intent)
                        finish()
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    showLoading(false)
                    Toast.makeText(this@CameraActivity,
                        getString(R.string.Upload_Gagal),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        }
    }

    private lateinit var currentPhotoPath: String
    private fun startCameraX() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.resolveActivity(packageManager)
        createTempFile(application).also {
            val photoURI: Uri = FileProvider.getUriForFile(
                this,
                "com.capstonebangkin.skin_diagnosis_app.ui",
                it
            )
            currentPhotoPath = it.absolutePath
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            launcherIntentCameraX.launch(intent)
        }
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
//        if (it.resultCode == CAMERA_X_RESULT) {
//            val myFile = it.data?.getSerializableExtra("picture") as File
//            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean
//
//            val result = rotateBitmap(
//                BitmapFactory.decodeFile(myFile.path),
//                isBackCamera
//            )
//
//            binding.previewImageView.setImageBitmap(result)
//        }
        if (it.resultCode == RESULT_OK) {
            val myFile = File(currentPhotoPath)
            val result = BitmapFactory.decodeFile(myFile.path)

            getFile = myFile
            binding.imgPosts.setImageBitmap(result)
        }
    }

    // this is camera


    //show loading
    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}