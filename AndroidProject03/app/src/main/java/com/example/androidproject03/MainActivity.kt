package com.example.androidproject03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import com.example.androidproject03.product.ProductInfoFragmentDirections

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent.getStringExtra("product")?.let {
            showProductInfo(it)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        intent?.getStringExtra("product")?.let {
            showProductInfo(it)
        }
        super.onNewIntent(intent)
    }


    private fun showProductInfo(productInfo: String) {
        this.findNavController(R.id.nav_host_fragment)
            .navigate(ProductInfoFragmentDirections.actionShowProductInfo(productInfo))
    }
}