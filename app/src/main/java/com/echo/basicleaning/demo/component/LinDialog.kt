package com.echo.basicleaning.demo.component

import android.app.Dialog
import android.content.Context
import com.echo.basicleaning.R

//class LinDialog(context: Context) : Dialog(context) {
//    init {
//
//        setContentView(R.layout.dialog)
//    }
//}
/***
 * 1.设计布局样式
 * 2.自定义style(去标题栏，去背景)
 * 3.将第一步的布局应用到当前自定义对话框
 * 4.实例化对话框
 * 5.show()
 */
class LinDialog(context: Context,themeResId:Int) : Dialog(context,themeResId) {
    init {
        setContentView(R.layout.dialog)
    }
}