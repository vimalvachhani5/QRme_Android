package com.berisco.qrme

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class Activity_Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        try {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            super.onCreate(savedInstanceState)
            startActivity(Intent(this, Activity_Auth_start::class.java))
            finish()
        }
        catch (ex: Exception){
                println("Printingxx : Exception XXXX   $ex")
        }


    }

}