package com.echo.basicleaning.demo.component

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.echo.basicleaning.R

//根据准备好的数据源和子项布局完成listview效果的一一设置
class MyAdapter(
    private val context: Context,
    private val studentList:List<Student>
): BaseAdapter() {


    override fun getCount(): Int {
        return studentList.size
    }

    override fun getItem(position: Int): Any {
        return studentList[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    //每个视图出现时都会执行
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item1,null)
        val stu = studentList[position]
        val nickName = view.findViewById<TextView>(R.id.nickname)
        nickName.text = stu.name
        return view
    }
}