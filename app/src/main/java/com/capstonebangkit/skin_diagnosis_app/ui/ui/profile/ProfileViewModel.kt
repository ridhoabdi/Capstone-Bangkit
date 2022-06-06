package com.capstonebangkit.skin_diagnosis_app.ui.ui.profile

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ProfileViewModel (private val pref: SettingPreferences) : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is profile Fragment"
    }
    val text: LiveData<String> = _text

    fun getThemeSettings(): LiveData<Boolean> {
        return pref.getThemeSetting().asLiveData()
    }

    fun saveThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            pref.saveThemeSetting(isDarkModeActive)
        }
    }
}