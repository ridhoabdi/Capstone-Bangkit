package com.capstonebangkit.skin_diagnosis_app.ui.ui.saran

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SaranViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is saran Fragment"
    }
    val text: LiveData<String> = _text
}