package com.smith.car_business

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var registerButton: Button
    private lateinit var tapToCallButton: Button
    private lateinit var phoneNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        registerButton = findViewById(R.id.buttonRegister)
        tapToCallButton = findViewById(R.id.buttonTapToCall)
        phoneNumber = findViewById(R.id.phoneNumber)

        // here we introduce a lambda function a func thats declear and call at same time
        registerButton.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        tapToCallButton.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:" + phoneNumber.text.toString()))
            startActivity(intent)
        }
    }
}