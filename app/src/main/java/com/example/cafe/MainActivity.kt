package com.example.cafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY = "com.example.cafe.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val orderBtn = findViewById<Button>(R.id.orderBtn)
        val eT1 = findViewById<EditText>(R.id.eT1)
        val eT2 = findViewById<EditText>(R.id.eT2)
        val eT3= findViewById<EditText>(R.id.eT3)
        orderBtn.setOnClickListener{
            val orderList ="Ordered" +"\n 1." + eT1.text.toString()+ "\n 2." + eT2.text.toString()+ "\n 3." + eT3.text.toString()
            intent= Intent(this,orderActivity::class.java )
            intent.putExtra(KEY,orderList)
            startActivity(intent)
        }
    }
}