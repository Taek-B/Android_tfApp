package com.example.tfapp

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException
import java.util.*

class ResultActivity : AppCompatActivity() {
    lateinit var cls: ClassifierWithModel
    lateinit var morebtn: Button
    lateinit var resultimg: ImageView
    lateinit var resulttxt: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        cls = ClassifierWithModel(this)
        try {
            cls.init()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        morebtn = findViewById(R.id.restart_btn)
        resultimg = findViewById(R.id.result_img)
        resulttxt = findViewById(R.id.result_txt)

        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)

        if (bitmap != null) {
            val (first, second) = cls.classify(bitmap)
            val resultStr: String =
                java.lang.String.format(Locale.ENGLISH, "%s", first)
            resultimg.setImageBitmap(bitmap)
            resulttxt.setText(resultStr+"\n"+ second*100 + '%')

        }


        morebtn.setOnClickListener {
            val intent = Intent(applicationContext, InputActivity::class.java)
            finish()
            cls.finish()
            startActivity(intent)
        }
    }
}