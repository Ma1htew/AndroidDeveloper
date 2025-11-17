package com.example.androiddeveloper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddeveloper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var addButton: Button? = null
    private var btnGoToEmpty: Button? = null
    private lateinit var adapter: ItemAdapter
    private val items = mutableListOf<Item>()
    private var itemId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupRecyclerView()
        setupClickListeners()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        addButton = findViewById(R.id.addButton)
        btnGoToEmpty = findViewById(R.id.btnGoToEmpty)
    }

    private fun setupRecyclerView() {
        adapter = ItemAdapter(items)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = adapter
    }

    private fun setupClickListeners() {
        addButton?.setOnClickListener {
            addNewItem()
        }

        btnGoToEmpty?.setOnClickListener {
            goToEmptyActivity()
        }
    }

    private fun addNewItem() {
        itemId++
        val newItem = Item(
            id = itemId,
            title = "element $itemId",
        )
        adapter.addItem(newItem)
        recyclerView?.smoothScrollToPosition(adapter.itemCount - 1)
    }

    private fun goToEmptyActivity() {
        val intent = Intent(this, EmptyActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        recyclerView = null
        addButton = null
        btnGoToEmpty = null
    }
}