package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupWindow
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityPopUpWindowBinding

class PopUpWindowActivity : AppCompatActivity() {
    lateinit var binding: ActivityPopUpWindowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopUpWindowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.popupwindow.setOnClickListener{

            //准备弹窗需要的视图对象
            val v = layoutInflater.inflate(R.layout.popup,null)

            /**
             * 1.用在弹窗中的view
             * 2.弹窗的宽高
             * 3.
             */
            val popupWindow = PopupWindow(v,600,400,true)
            popupWindow.showAsDropDown(binding.popupwindow)
        }
    }
}