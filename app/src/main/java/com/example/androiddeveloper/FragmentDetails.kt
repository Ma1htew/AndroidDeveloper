package com.example.androiddeveloper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androiddeveloper.databinding.FragmentDetailsBinding

class FragmentDetails : Fragment(R.layout.fragment_details) {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val mainActivity: MainActivity
        get() = activity as MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.detailsCounter++
        binding.counterText.text = "Details visited: ${mainActivity.detailsCounter} times"
        binding.buttonDetails.setOnClickListener {
            findNavController().navigate(R.id.action_navDetails_to_navSettings)
        }
        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_details_back)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}