package com.echo.basicleaning.demo.component

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.echo.basicleaning.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("fragment","create--fragment创建好了")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("fragment","onAttach--fragment与activity关联")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("fragment","onCreateView--fragment创建视图")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank1, container, false)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("fragment","onDestroyView-fragment视图销毁")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("fragment","onDetach-与activity解除关联")
    }


}