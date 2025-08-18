package com.echo.basicleaning.demo.component

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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




        // 方式1：使用新 API（Android 13+ 推荐）
        val student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("key", Student::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key") as? Student // 旧方式（兼容低版本）
        }
        // 使用对象
        student?.let {
            Log.d("StudentInfo", "姓名: ${it.name}, 年龄: ${it.age}")
            // 更新 UI 或执行业务逻辑
        }



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
        binding.goButton.text = "前往"
        binding.goButton.setOnClickListener ( object:View.OnClickListener{
            override fun onClick(v: View) {
//                Toast.makeText(v.context,"123",Toast.LENGTH_LONG).show()
//
//                startActivity(myIntent)
                val resultIntent = Intent()
                resultIntent.putExtra("key_name","你好啊")
                setResult(RESULT_OK,resultIntent)
                finish()

            }

        } )
//        binding.goButton.setOnClickListener {
//            Toast.makeText(this,"dasdas",Toast.LENGTH_LONG).show()
//        }
    }
}