package com.example.w6_d3_sign_up_in

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Details : AppCompatActivity() {

    private lateinit var mobileTextView : TextView
    private lateinit var locationTextView : TextView

    private lateinit var signoutButton : Button

    private lateinit var dbhr : DBHlpr

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val phone = intent.getStringExtra("Phone")

        dbhr = DBHlpr(applicationContext)

        mobileTextView = findViewById(R.id.mobileTextView)
        locationTextView = findViewById(R.id.locationTextView)

        mobileTextView.text = "Welcome $phone"

        var result = dbhr.retrive(phone.toString())
        locationTextView.text = result

        Toast.makeText(applicationContext,"Data Retrieved Successfully " + result, Toast.LENGTH_SHORT).show()

        signoutButton = findViewById(R.id.signoutButton)
        signoutButton.setOnClickListener {
            Intent(this@Details, MainActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}