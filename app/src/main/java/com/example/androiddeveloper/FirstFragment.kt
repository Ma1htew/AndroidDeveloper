package com.example.androiddeveloper

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androiddeveloper.databinding.ActivityMainBinding
import com.example.androiddeveloper.databinding.FragmentDetailsBinding
import com.example.androiddeveloper.databinding.FragmentFirstBinding
import com.example.androiddeveloper.databinding.FragmentSettingsBinding



class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFirstFrag.setOnClickListener {
            val message = binding.etMessage.text.toString()
            val action = FirstFragmentDirections.actionNavFirstFragmentToNavSecondFragment(message)
            findNavController().navigate(action)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("RETURN_DATA")
            binding.textViewResult.text = result
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}