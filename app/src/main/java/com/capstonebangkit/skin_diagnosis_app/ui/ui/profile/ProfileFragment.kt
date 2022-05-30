package com.capstonebangkit.skin_diagnosis_app.ui.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.FragmentHomeBinding
import com.capstonebangkit.skin_diagnosis_app.databinding.FragmentProfileBinding
import com.capstonebangkit.skin_diagnosis_app.ui.datastore.SettingPreferences
import com.capstonebangkit.skin_diagnosis_app.ui.settingtheme.SettingThemeActivity
import com.capstonebangkit.skin_diagnosis_app.ui.settingtheme.Theme
import com.capstonebangkit.skin_diagnosis_app.ui.settingtheme.ThemeViewModel


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //hallo
    //ini aku boi
    //iya
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

    }
}