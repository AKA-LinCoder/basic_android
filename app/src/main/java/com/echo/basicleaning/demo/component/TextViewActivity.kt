package com.echo.basicleaning.demo.component

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityTextViewBinding


class TextViewActivity : AppCompatActivity() {
//    lateinit var tv1:TextView
//    lateinit var tv2:TextView
    lateinit var binding: ActivityTextViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        tv1 = findViewById(R.id.tv1)
//        tv2 = findViewById(R.id.tv2)
//        tv1.text = "你好啊"
//        tv2.isSelected = true
        binding.tv1.text = "niasdnasldas"
        binding.tv2.text = "56123125"

    }
}