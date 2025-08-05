package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.echo.basicleaning.R

class TextViewActivity : AppCompatActivity() {
    lateinit var tv1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

        tv1 = findViewById(R.id.tv1)
        tv1.text = "你好啊"
    }
}