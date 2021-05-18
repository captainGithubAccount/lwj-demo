package com.lwj.lwj_module_home.ui.main.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lwj.common.base.BaseFragment
import com.lwj.lwj_module_home.R

class HomeMineFragment: BaseFragment(R.layout.fragment_home_mine) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_home_mine, container, false)
        view.run {
            initEvent(this)
        }
        return view

    }

    private fun initEvent(view: View?) {

    }

}