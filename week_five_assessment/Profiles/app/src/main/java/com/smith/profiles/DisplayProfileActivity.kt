package com.smith.profiles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smith.profiles.databinding.ActivityDisplayProfileBinding

class DisplayProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityDisplayProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        binding.profilePic.setImageResource(bundle!!.getInt("resId"))
        binding.fullName.text =
            "${bundle!!.getString("firstName")} ${bundle!!.getString("lastName")}"


    }
}