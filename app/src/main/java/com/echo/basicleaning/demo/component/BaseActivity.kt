package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    lateinit var binding: ActivityBaseBinding
     var studentList = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDate()
        val  adapter = MyAdapter(this,studentList)
        binding.buttonAdd.setOnClickListener {

        }
        binding.listView3.adapter = adapter
    }

    private fun initDate() {

        for (i in 0..9){
            val stu = Student("mike$i",i,(i*100).toString())
            studentList.add(stu)
        }
    }
}