package com.echo.basicleaning.demo.component

import android.content.Context
import android.util.Log
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
        val view: View
        val viewHolder: ViewHolder

        ///优化1，利用进入recyclerbin中的view,减少对view的赋值
        if (convertView == null) {
            Log.e("TAG","创建-------$position")
            view = LayoutInflater.from(context).inflate(R.layout.item1, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val stu = studentList[position]
        viewHolder.nickName.text = stu.name

        return view
    }

    private class ViewHolder(view: View) {
        val nickName: TextView = view.findViewById(R.id.nickname)
    }

}
