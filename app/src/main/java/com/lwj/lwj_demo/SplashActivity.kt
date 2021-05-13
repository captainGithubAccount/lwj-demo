package com.lwj.lwj_demo


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.WindowManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lwj.common.base.BaseActivity
import com.lwj.common.ktx.transparencyStatusBar
import com.lwj.lwj_module_home.service.HomeRouterTable



/*
* app 启动页
* */
class SplashActivity : BaseActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //当存在导航栏的时候防止导航栏遮住背景图片用的,取代了window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)方法
        window.navigationBarColor = 0x1AC0C0C0.toInt()
        //0xffff00ff是int类型的数据，分组一下0x|ff|ff00ff，0x表示颜色整数的标记，ff表示透明度，f00f表示色值，注意：0x后面ffff00ff必须是8位的颜色表示。1A表示10%透明度

        //延时处理消息
        Handler(Looper.myLooper()!!).postDelayed({
            //ARouter跳转到HomeAtv
            ARouter.getInstance().build(HomeRouterTable.PATH_ACTIVITY_HOME).navigation();
            finish();
        }, 3000)
    }
}