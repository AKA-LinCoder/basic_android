package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.doOnTextChanged
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityTextInputBinding

class TextInputActivity : AppCompatActivity() {
    lateinit var binding: ActivityTextInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.errorCheck.editText?.addTextChangedListener(object:TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("Not yet implemented")
//                if(s?.length!=11){
//                    binding.errorCheck
//                }
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//        })
        binding.phoneEdit.doOnTextChanged { text, start, before, count ->
            if(text?.length!=11){
                binding.errorCheck.error = "手机格式不对"
            }else {
                binding.errorCheck.error = null
                binding.phoneEdit.text.toString()
            }
        }
    }
}