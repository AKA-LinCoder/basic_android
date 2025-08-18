package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.echo.basicleaning.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}