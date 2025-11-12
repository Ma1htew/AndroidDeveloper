package com.example.androiddeveloper

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: FragmentDynamic
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
        setupClickListeners()
    }

    private fun setupViewPager() {
        viewPager = findViewById(R.id.viewPager)
        adapter = FragmentDynamic(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        addFragment()
    }

    private fun setupClickListeners() {
        findViewById<Button>(R.id.btnAddFragment).setOnClickListener {
            addFragment()
        }

        findViewById<Button>(R.id.btnRemoveFragment).setOnClickListener {
            removeFragment()
        }
    }

    private fun addFragment() {
        counter++
        val fragment = FragmentFirst.newInstance("Fragment $counter")
        adapter.addFragment(fragment)
        viewPager.currentItem = adapter.itemCount - 1
    }

    private fun removeFragment() {
        if (adapter.itemCount > 1) {
            adapter.removeFragment(viewPager.currentItem)
        } else {
            Toast.makeText(this, "don't delete last fragment", Toast.LENGTH_SHORT).show()
        }
    }
}