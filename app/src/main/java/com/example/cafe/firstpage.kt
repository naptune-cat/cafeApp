package com.example.cafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class firstpage : AppCompatActivity() {
    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstpage)

        val signupBtn= findViewById<Button>(R.id.signupBtn)
        val etName= findViewById<TextInputEditText>(R.id.eTname)
        val etMail = findViewById<TextInputEditText>(R.id.eTEmail)
        val etUsername = findViewById<TextInputEditText>(R.id.eTUsername)
        val userPassword =findViewById<TextInputEditText>(R.id.password)
        val directLogin = findViewById<TextView>(R.id.tvRedirectSignUp)
        directLogin.setOnClickListener{
            intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        signupBtn.setOnClickListener {
            val name = etName.text.toString()
            val mail = etMail.text.toString()
            val userid = etUsername.text.toString()
            val password = userPassword.text.toString()

            val user = User(name,mail,password ,userid)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(userid).setValue(user).addOnSuccessListener {

                Toast.makeText(this,"Registration Successful",Toast.LENGTH_SHORT).show()
                val i = Intent(this,LoginActivity::class.java)
                startActivity(i)
            }.addOnFailureListener {
                Toast.makeText(this,"Invalid try again",Toast.LENGTH_SHORT).show()
            }

        }

    }
}