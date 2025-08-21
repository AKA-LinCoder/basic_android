package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.echo.basicleaning.R

class ViewPager2Activity : AppCompatActivity() {
    lateinit var array: MutableList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)
        array = mutableListOf()
        array.add(R.mipmap.ic_launcher)
        array.add(com.google.android.material.R.drawable.abc_dialog_material_background)
        array.add(R.drawable.ic_launcher_background)
        val pages = findViewById<ViewPager2>(R.id.pages)
        pages.adapter = MyAdapter(array)
    }

    inner  class MyAdapter(private val  images:List<Int>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
        // 定义ViewHolder类，用于缓存视图
        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val container: LinearLayout = itemView.findViewById(R.id.container)  // 假设item_layout中有一个TextView，其ID为text_view
        }
//        inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            val imageView: ImageView = itemView.findViewById(R.id.imageView)
//        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
           return  MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return images.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val realPos = position %images.size
            holder.container.setBackgroundResource(images[position])
        }
    }
}