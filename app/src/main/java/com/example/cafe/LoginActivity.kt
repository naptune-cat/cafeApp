package com.example.cafe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email = findViewById<TextInputEditText>(R.id.loginEmail)
        val password = findViewById<TextInputEditText>(R.id.loginpassword)
        val loginBtn = findViewById<Button>(R.id.signinBtn)
        auth = FirebaseAuth.getInstance()

        loginBtn.setOnClickListener {
            val mail = email.text.toString()
            val pass = password.text.toString()

            if(mail.isNotEmpty() && pass.isNotEmpty()) {
                auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener {
                    if(it.isSuccessful){
                       val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                }
            }  else{
                Toast.makeText(this,"Fields cannot be empty",Toast.LENGTH_LONG).show()
            }
        }
    }

}
