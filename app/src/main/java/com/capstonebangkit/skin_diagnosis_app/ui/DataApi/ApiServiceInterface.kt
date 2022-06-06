package com.capstonebangkit.skin_diagnosis_app.ui.DataApi

import android.provider.ContactsContract
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiServiceInterface {
    @Multipart
    @POST("Upload")
    fun uploadimage(
        @Part file: MultipartBody.Part ,
    ): Call<res>
}

data class res (
    val Prediksi: String?,
    val Presentase: String?,
    val Obat: String?
        )
