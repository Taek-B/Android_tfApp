package com.example.tfapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var morebtn: Button
    lateinit var resultimg: ImageView
    lateinit var resulttxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


    }
}