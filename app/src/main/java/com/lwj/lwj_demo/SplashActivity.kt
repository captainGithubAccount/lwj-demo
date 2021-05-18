package com.lwj.lwj_demo


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.WindowManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lwj.common.base.BaseActivity
import com.lwj.common.ktx.navigationColor

import com.lwj.lwj_module_home.service.HomeRouterTable



/*
* app 启动页
* */
class SplashActivity : BaseActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //设置导航栏颜色和透明度
        navigationColor(0x1AC0C0C0)


        //延时处理消息
        Handler(Looper.myLooper()!!).postDelayed({
            //ARouter跳转到HomeAtv
            ARouter.getInstance().build(HomeRouterTable.PATH_ACTIVITY_HOME).navigation();
            finish();
        }, 1000)
    }
}