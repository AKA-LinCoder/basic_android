package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityProgressBarBinding

class ProgressBarActivity : AppCompatActivity() {
    lateinit var binding: ActivityProgressBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread{
            run {
               for(i in 1..100){
                   runOnUiThread{
                       binding.progress.progress = i
                   }
                   Thread.sleep(30)
            }
            }
        }.start()

        binding.checkbox.setOnCheckedChangeListener{ buttonView,isChecked ->

            if (isChecked) {
                // 勾选时执行
                Toast.makeText(this, "已选中", Toast.LENGTH_SHORT).show()
            } else {
                // 取消勾选时执行
                Toast.makeText(this, "取消选中", Toast.LENGTH_SHORT).show()
            }
        }
    }
}