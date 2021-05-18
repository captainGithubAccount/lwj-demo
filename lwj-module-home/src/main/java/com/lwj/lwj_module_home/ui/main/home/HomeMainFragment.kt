package com.lwj.lwj_module_home.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lwj.common.base.BaseFragment
import com.lwj.lwj_module_home.R

class HomeMainFragment: BaseFragment(R.layout.fragment_home_home) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_home_home, container, false)
        view.run {
            initEvent(view)
        }

        return view
    }

    fun initEvent(view: View){}
}