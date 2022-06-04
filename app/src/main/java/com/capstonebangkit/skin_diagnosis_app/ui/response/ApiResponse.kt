package com.capstonebangkit.skin_diagnosis_app.ui.response

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val notif: String
)
