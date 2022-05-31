package com.capstonebangkit.skin_diagnosis_app.ui.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*


class ProfileFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //hallo
    //ini aku boi
    //iya
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_profile, container, false)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imageViewProfile: ImageView = binding.profileImage
        val textViewProfile: TextView = binding.tvEmail

        auth = Firebase.auth
        val firebaseUser = auth.currentUser

        if (firebaseUser != null) {
            imageViewProfile.setImageURI(firebaseUser!!.photoUrl)
            textViewProfile.setText(firebaseUser.email.toString()).toString()
        }

        return root

    }
    
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//    }
    //option menu
}


