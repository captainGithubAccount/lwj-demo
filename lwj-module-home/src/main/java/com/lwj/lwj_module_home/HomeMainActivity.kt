package com.lwj.lwj_module_home


import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.lwj.common.base.BaseActivity
import com.lwj.common.ktx.userStatusBarColor

import com.lwj.lwj_module_home.service.HomeRouterTable


@Route(path = HomeRouterTable.PATH_ACTIVITY_HOME)
class HomeMainActivity: BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)


    }
}