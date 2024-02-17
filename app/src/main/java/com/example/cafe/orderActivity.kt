package com.example.cafe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class orderActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val ordersOfCustomer =  intent.getStringExtra(MainActivity.KEY)
        val tVOrder = findViewById<TextView>(R.id.tOrder)
        tVOrder.text = ordersOfCustomer.toString()
    }
}