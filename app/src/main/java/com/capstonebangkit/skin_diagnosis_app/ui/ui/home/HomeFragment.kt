package com.capstonebangkit.skin_diagnosis_app.ui.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.FragmentHomeBinding
import com.capstonebangkit.skin_diagnosis_app.ui.Camera.CameraActivity
import com.capstonebangkit.skin_diagnosis_app.ui.ui.profile.ProfileFragment
import com.capstonebangkit.skin_diagnosis_app.ui.ui.saran.SaranFragment


class HomeFragment : Fragment() , View.OnClickListener{

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //hallo
    //ini aku boi
    //iya
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        //val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//        //textView.text = it
//        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardCameraAction: CardView = view.findViewById(R.id.cameraAction)
        cardCameraAction.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        if (v.id == R.id.cameraAction) {
//            val mProfileFragment = ProfileFragment()
//            val mFragmentManager = parentFragmentManager
//            mFragmentManager.beginTransaction().apply {
//                replace(R.id.nav_host_fragment_activity_bottom_nav, mProfileFragment, ProfileFragment::class.java.simpleName)
//                addToBackStack(null)
//                commit()
//            }
            val mIntent = Intent(requireContext(), CameraActivity::class.java)
            startActivity(mIntent)
        }
    }
}

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

