package com.capstonebangkit.skin_diagnosis_app.ui.ui.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.FragmentProfileBinding
import com.capstonebangkit.skin_diagnosis_app.ui.ui.about.AboutAppActivity
import com.capstonebangkit.skin_diagnosis_app.ui.ui.contact.ContactUsActivity

import com.capstonebangkit.skin_diagnosis_app.ui.ui.welcome.WelcomeUserActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imageViewProfile: ImageView = binding.profileImage
        val textViewProfile: TextView = binding.tvEmail

        auth = Firebase.auth
        val firebaseUser = auth.currentUser

        if (firebaseUser != null) {
            imageViewProfile.setImageURI(firebaseUser.photoUrl)
            textViewProfile.setText(firebaseUser.email.toString()).toString()
        }

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // language
        multipleLanguage()

        // about app
        binding.aboutApp.setOnClickListener {
            aboutAppButton()
        }

        // contact us
        binding.contactUs.setOnClickListener {
            contactUsButton()
        }

        // logout
        binding.logOut.setOnClickListener {
            logoutButton()
        }

    }

    private fun multipleLanguage() {
        binding.switchLanguage.setOnClickListener {
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
        }
    }

    private fun aboutAppButton() {
        val a = Intent(context, AboutAppActivity::class.java)
        startActivity(a)
    }

    private fun contactUsButton() {
        val c = Intent(context, ContactUsActivity::class.java)
        startActivity(c)
    }


    private fun logoutButton() {
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val i = Intent(context, WelcomeUserActivity::class.java)
        startActivity(i)
        activity?.finish()
    }


}


