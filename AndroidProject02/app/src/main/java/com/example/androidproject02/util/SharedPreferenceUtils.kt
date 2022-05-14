package com.example.androidproject02.util

import android.content.Context
import android.content.SharedPreferences
import com.example.androidproject02.MainApplication

private const val ACCESS_TOKEN = "access_token"
private const val EXPIRES_IN = "expires_in"

object SharedPreferenceUtils {

    fun saveToken(accessToken: String, expiresIn: Int){
        with (getSharedPreferences().edit()){
            putString(ACCESS_TOKEN, accessToken)
            putInt(EXPIRES_IN, ((System.currentTimeMillis() / 1000) + expiresIn).toInt())
        }
    }

    fun getAccessToken(): String? {
        var accessToken: String? = null

        with (getSharedPreferences()){
            if(contains(ACCESS_TOKEN) && contains(EXPIRES_IN)) {
                val expiresIn = getInt(EXPIRES_IN, 0)
                if(expiresIn > (System.currentTimeMillis() / 1000))
                {
                    accessToken = getString(ACCESS_TOKEN, "")
                }
            }
        }

        return accessToken
    }

    private fun getSharedPreferences(): SharedPreferences {
        return MainApplication.getApplicationContext().getSharedPreferences("main", Context.MODE_PRIVATE)
    }
}