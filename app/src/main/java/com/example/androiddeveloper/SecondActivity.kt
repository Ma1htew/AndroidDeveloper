package com.example.androiddeveloper

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val name = intent.getStringExtra("done")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "done, $name!"
    val messageFromR = getString(R.string.task16_5)
        textView.text = "$messageFromR\ndone, $name!"
    }
}