package com.example.androidproject04.product

import android.util.Log
import androidx.databinding.InverseMethod
import java.lang.NumberFormatException

object PriceConverter {
    @InverseMethod("stringToPrice")
    @JvmStatic
    fun priceToString(newValue: Double): String {
        return "$ " + "%.2f".format(newValue)
    }

    @JvmStatic
    fun stringToPrice(newValue: String): Double {
        var price = 0.0
        try {
            price = newValue.removePrefix("$").trim().replace(",", ".").toDouble()
        } catch (e: NumberFormatException) {
            Log.e("PriceConverter", " Failed to convert price")
        }
        return price
    }
}