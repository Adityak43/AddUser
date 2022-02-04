package com.app.adduserapp.presentation.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import com.app.adduserapp.presentation.MainActivity

abstract class BaseFragment :Fragment (){
    lateinit var mainActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity= context as MainActivity
    }
}