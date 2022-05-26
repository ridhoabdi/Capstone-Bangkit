package com.capstonebangkit.skin_diagnosis_app.ui.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.FragmentHomeBinding
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Camera.CameraActivity
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Description.DescriptionActivity
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Panduan.PanduanActivity
import com.capstonebangkit.skin_diagnosis_app.ui.DashboardUI.Upload.UploadActivity


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
        //deskripsikan variabel
        val cardCameraAction: CardView = view.findViewById(R.id.cameraClick)
        val cardUploadAction: CardView = view.findViewById(R.id.uploadClick)
        val cardPanduanAction: CardView = view.findViewById(R.id.panduanClick)
        val cardDescriptionAction: CardView = view.findViewById(R.id.descriptionClick)

        //action
        cardCameraAction.setOnClickListener(this)
        cardUploadAction.setOnClickListener(this)
        cardPanduanAction.setOnClickListener(this)
        cardDescriptionAction.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        if (v.id == R.id.cameraClick) {
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
        if (v.id == R.id.uploadClick) {
            val mIntent = Intent(requireContext(), UploadActivity::class.java)
            startActivity(mIntent)
        }
        if (v.id == R.id.panduanClick) {
            val mIntent = Intent(requireContext(), PanduanActivity::class.java)
            startActivity(mIntent)
        }
        if (v.id == R.id.descriptionClick) {
            val mIntent = Intent(requireContext(), DescriptionActivity::class.java)
            startActivity(mIntent)
        }
    }
}


