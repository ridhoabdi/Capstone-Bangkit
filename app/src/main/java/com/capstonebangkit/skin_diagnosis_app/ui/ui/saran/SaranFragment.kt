package com.capstonebangkit.skin_diagnosis_app.ui.ui.saran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstonebangkit.skin_diagnosis_app.databinding.FragmentSaranBinding


class SaranFragment : Fragment() {

    private var _binding: FragmentSaranBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val saranViewModel =
            ViewModelProvider(this).get(SaranViewModel::class.java)

        _binding = FragmentSaranBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSaran
        saranViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}