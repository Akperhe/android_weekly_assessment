package com.smith.car_business

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var con : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
con = findViewById(R.id.continueButton)
        con.setOnClickListener {
            val intent: Intent = Intent(this, trial::class.java)
            startActivity(intent)
        }
    }
}