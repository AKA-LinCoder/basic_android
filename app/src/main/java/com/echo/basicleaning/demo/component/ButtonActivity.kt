package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding: ActivityButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener {
            Toast.makeText(this,"123456",Toast.LENGTH_LONG).show()
        }
        binding.login2.setOnClickListener (this)
    }

    fun click1(view: View) {
        Toast.makeText(this,"hahah",Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.login2 ->{
                Toast.makeText(this,"who are you",Toast.LENGTH_LONG).show()
            }
        }
    }
}