package com.echo.basicleaning.demo.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.echo.basicleaning.R
import com.echo.basicleaning.databinding.ActivityLifeBinding

class LifeActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding: ActivityLifeBinding

    /***
     * 1 正常启动：create->start->resume 正常退出：pause->stop->onDestroy
     * 2 已经处于前台的activity，点击主页按钮离开当前activity：pause->stop,回到activity：restart->start->resume
     * 3 activity不可操作(熄屏，打开了其他activity)，而应用被强行杀死，再回到activity时：create->start->resume
     */
    //创建
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)


        //contextMenu
        registerForContextMenu(binding.button3)

//        setSupportActionBar(binding.t)
        Log.e("Tag","---------onCreate---------")
    }
    //启动
    override fun onStart() {
        super.onStart()
        Log.e("Tag","---------onStart---------")
    }

    //恢复
    override fun onResume() {
        super.onResume()
        Log.e("Tag","---------onResume---------")
    }

    //暂停
    override fun onPause() {
        super.onPause()
        Log.e("Tag","---------onPause---------")
    }

    //停止
    override fun onStop() {
        super.onStop()
        Log.e("Tag","---------onStop---------")
    }

    //销毁
    override fun onDestroy() {
        super.onDestroy()
        Log.e("Tag","---------onDestroy---------")
    }

    //重启
    override fun onRestart() {
        super.onRestart()
        Log.e("Tag","---------onRestart---------")
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button1->{
                Log.e("Tag","---------我是button1---------")
            }
            R.id.button2->{
                Log.e("Tag","---------我是button2---------")
            }
            R.id.button3->{
                Log.e("Tag","---------我是button3---------")
            }
        }
    }

    ///创建optionMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        ///加载菜单资源
        menuInflater.inflate(R.menu.option,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save ->{

                Toast.makeText(this,"save",Toast.LENGTH_LONG).show()
            }
            R.id.more -> {
                Toast.makeText(this,"more",Toast.LENGTH_LONG).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context,menu)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save ->{

                Toast.makeText(this,"save",Toast.LENGTH_LONG).show()
            }
            R.id.more -> {
                Toast.makeText(this,"more",Toast.LENGTH_LONG).show()
            }
        }
        return super.onContextItemSelected(item)
    }


}