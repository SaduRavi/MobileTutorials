package com.example.dogbreed

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val backButton = findViewById<Button>(R.id.button4)
        backButton.setOnClickListener {
            val contactIntent = Intent(this, MainActivity::class.java)
            startActivity(contactIntent)
        }

        val correct = findViewById<TextView>(R.id.textView)
        val incorrect = findViewById<TextView>(R.id.textView3)

        correct.setBackgroundColor(Color.GREEN)
        incorrect.setBackgroundColor(Color.RED)

        val correctNum = intent.getStringExtra("correct")
        val wrongNum = intent.getStringExtra("wrong")
        correct.text = correctNum
        incorrect.text = wrongNum
    }
}