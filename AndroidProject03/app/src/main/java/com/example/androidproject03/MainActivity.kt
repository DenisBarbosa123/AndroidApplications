package com.example.androidproject03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent.getStringExtra("product")?.let {
            Log.i("MainActivity", it)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        intent?.getStringExtra("product")?.let {
            Log.i("MainActivity", it)
        }

        super.onNewIntent(intent)
    }
}