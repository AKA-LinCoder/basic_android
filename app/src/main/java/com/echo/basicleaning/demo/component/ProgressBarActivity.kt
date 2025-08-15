package com.echo.basicleaning.demo.component

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.SeekBar
import android.widget.Toast
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityProgressBarBinding

class ProgressBarActivity : AppCompatActivity() {
    lateinit var binding: ActivityProgressBarBinding
    lateinit var myIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBarBinding.inflate(layoutInflater)
        myIntent = Intent(this,ButtonActivity::class.java)
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

        binding.seekbar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
//                getString(R.string.app_name)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

        })
        binding.goButton.setText("前往")
        binding.goButton.setOnClickListener ( object:View.OnClickListener{
            override fun onClick(v: View) {
//                Toast.makeText(v.context,"123",Toast.LENGTH_LONG).show()
//
//                startActivity(myIntent)
                val resultIntent = Intent()
                resultIntent.putExtra("key_name","你好啊")
                setResult(100,resultIntent)
                finish()

            }

        } )
//        binding.goButton.setOnClickListener {
//            Toast.makeText(this,"dasdas",Toast.LENGTH_LONG).show()
//        }
    }
}