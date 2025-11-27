package com.example.androiddeveloper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androiddeveloper.databinding.FragmentHomeBinding
import com.example.androiddeveloper.databinding.FragmentSettingsBinding

class FragmentSettings : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val mainActivity: MainActivity
        get() = activity as MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.settingsCounter++
        binding.counterText.text = "Settings visited: ${mainActivity.settingsCounter} times"

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_navSettings_to_navDetails4)
        }
        binding.buttontofirst.setOnClickListener {
            findNavController().navigate(R.id.action_navSettings_to_navFirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
