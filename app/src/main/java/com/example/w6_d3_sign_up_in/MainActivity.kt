package com.example.w6_d3_sign_up_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var signinButton : Button
    private lateinit var signupButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signinButton = findViewById(R.id.signinButton)
        signupButton = findViewById(R.id.signupButton)

        signinButton.setOnClickListener {
            Intent(this@MainActivity, SignIn::class.java).apply {
                startActivity(this)
            }
        }

        signupButton.setOnClickListener {
            Intent(this@MainActivity, SignUp::class.java).apply {
                startActivity(this)
            }
        }
    }
}