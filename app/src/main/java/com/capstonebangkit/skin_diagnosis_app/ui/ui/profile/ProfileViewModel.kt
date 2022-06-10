package com.capstonebangkit.skin_diagnosis_app.ui.ui.profile

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is profile Fragment"
    }
    val text: LiveData<String> = _text

}