package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}