package com.example.agrodetect_mobile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartNow = findViewById<Button>(R.id.btnStartNow)

        btnStartNow.setOnClickListener{
            val i = Intent(this,  LoginActivity::class.java)
            startActivity(i)

        }

    }
}