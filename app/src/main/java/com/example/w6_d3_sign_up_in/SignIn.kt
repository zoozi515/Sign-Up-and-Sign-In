package com.example.w6_d3_sign_up_in

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignIn : AppCompatActivity() {

    private lateinit var mobileEditText : EditText
    private lateinit var passwordEditText : EditText

    private lateinit var signinButton : Button

    private lateinit var dbhr : DBHlpr

    private var phone = ""
    private var password = ""
    private var result = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        // 0554444444 yousef123

        dbhr = DBHlpr(applicationContext)

        mobileEditText = findViewById(R.id.mobileEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        signinButton = findViewById(R.id.signinButton)
        signinButton.setOnClickListener {
            phone = mobileEditText.text.toString()
            password = passwordEditText.text.toString()

            var result = dbhr.checkUser(phone,password)
            if(result == "user not exists"){
                Toast.makeText(applicationContext,"Enter Correct Phone or Password", Toast.LENGTH_SHORT).show()
            } else if (result == "user found"){
                val intent = Intent(this@SignIn, Details::class.java).apply {
                    putExtra("Phone", phone)
                }
                startActivity(intent)
            }
        }
    }
}