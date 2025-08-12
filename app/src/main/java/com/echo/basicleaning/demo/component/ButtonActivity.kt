package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityButtonBinding

public class ButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtonBinding
    lateinit var mcl: MyClicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener {
            Toast.makeText(this,"123456",Toast.LENGTH_LONG).show()
        }
//        binding.login2.setOnClickListener (this)

        mcl =  MyClicker()
        binding.tapme1.setOnClickListener ( mcl )

        binding.tapme2.setOnClickListener {
            Toast.makeText(this,"匿名内部类",Toast.LENGTH_LONG).show()
            finish()
        }

    }

    fun click1(view: View) {

        when (view.id){
            R.id.login2 -> {
                Toast.makeText(this,"hahah",Toast.LENGTH_LONG).show()
            }
        }
    }



    class MyClicker : View.OnClickListener{
        override fun onClick(v: View?) {
            Log.e("TAG","通过内部类监听对象的按钮")

        }

    }
}