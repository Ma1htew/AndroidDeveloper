package com.example.androiddeveloper

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class FragmentFirst : Fragment(R.layout.fragment_first) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString("title") ?: "Fragment"
        view.findViewById<TextView>(R.id.textView).text = title
    }

    companion object {
        fun newInstance(title: String): FragmentFirst {
            return FragmentFirst().apply {
                arguments = Bundle().apply {
                    putString("title", title)
                }
            }
        }
    }
}
