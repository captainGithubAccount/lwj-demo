package com.lwj.lwj_demo


import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lwj.common.base.BaseActivity
import com.lwj.lwj_module_home.service.HomeRouterTable



class AppLoadSplashActivity : BaseActivity(R.layout.activity_app_load_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_load_splash)

        ARouter.getInstance().build(HomeRouterTable.PATH_ACTIVITY_HOME).navigation();
        finish();
    }

}