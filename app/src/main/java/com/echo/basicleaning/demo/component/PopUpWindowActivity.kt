package com.echo.basicleaning.demo.component

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
            val popupWindow = PopupWindow(v,490,90,true)
            popupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //默认点击其他地方关闭
//            popupWindow.isOutsideTouchable
            popupWindow.showAsDropDown(binding.popupwindow,100,50)
            popupWindow.animationStyle.div(R.style.translate_anim)
            v.findViewById<TextView>(R.id.choose).setOnClickListener {

            }
            v.findViewById<TextView>(R.id.selectAll).setOnClickListener {

            }
            v.findViewById<TextView>(R.id.copy).setOnClickListener {

                Log.e("Tag","点击copy")
                popupWindow.dismiss()
            }
        }
        binding.arrayAdapterBtn.setOnClickListener {
            val  items = arrayListOf<String>("java","kotlin","mysql")
//            val adapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,items)
            val adapter = ArrayAdapter(this,R.layout.array_item_layout,R.id.item_tx,items)
            val  builder = AlertDialog.Builder(this)
                .setTitle("请选择")
                .setAdapter(adapter) { dia, which ->
                    Toast.makeText(this, items[which], Toast.LENGTH_LONG).show()
                    dia.dismiss()
                }
            builder.show()
        }
    }
}