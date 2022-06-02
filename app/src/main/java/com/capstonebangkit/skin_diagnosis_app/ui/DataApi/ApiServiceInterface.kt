package com.capstonebangkit.skin_diagnosis_app.ui.DataApi

import com.capstonebangkit.skin_diagnosis_app.ui.response.ApiResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiServiceInterface {
    @Multipart
    @POST("postsimage")
    fun uploadimage(
        @Part file: MultipartBody.Part,
    ): Call<ApiResponse>
}