package com.smith.contactapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smith.contactapp.databinding.ActivityContactDashboardBinding


class ContactDashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fullName.text =
            "${intent.getStringExtra("firstName")} ${intent.getStringExtra("lastName")}"
        binding.phoneNumber.text = intent.getStringExtra("phoneNumber")
        binding.emailAddress.text = intent.getStringExtra("emailAddress")


    }
}