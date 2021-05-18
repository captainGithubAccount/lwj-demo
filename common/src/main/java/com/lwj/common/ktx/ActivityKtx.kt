package com.lwj.common.ktx

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.*


import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.core.view.WindowInsetsCompat.Type.*
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner


//region 扩展属性
/*
*  TODO(扩展lifeCycleOwner属性，便于和Fragment使用的lifeCycleOwner保持一致性)
* */
val ComponentActivity.viewLifeCycleOwner: LifecycleOwner
    get() = this

/*
* TODO(扩展属性，因为经常要传入Activity的上下文，而且context对象通常所见都是this)
* */
val Activity.context: Context
    get() = this
//endregion


//region 扩展函数
/*
* @LayoutRes注解: 提示你传入的是一个资源布局文件，防止你传入1，2这种Int类型的对象(kotlin一切皆对象，不存在基本数据类型)
* TODO(返回一个Binding对象实例)
* */
fun<T: ViewDataBinding> Activity.bindView(@LayoutRes layoutId: Int): T{
    return DataBindingUtil.setContentView<T>(this, layoutId)

}

/*
* TODO(返回一个Binding对象实例T类型的)
* */
fun<T: ViewDataBinding> Activity.bindView(view: View): T?{
    return DataBindingUtil.bind<T>(view)
}

/*
* TODO(透明化状态栏/沉浸式状态栏)
* 已过时方法
* 界面Activity的沉浸式状态栏，使得可以在状态栏显示部分需要的图片
* node: 需要在setContentView之前调用该函数才生效
* */


/*
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.transparencyStatusBarDeprecated(){
    window.apply {
        addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
    // Hide the status bar.
//注意两个Flag必须要结合在一起使用，表示会让应用的主体内容占用系统状态栏的空间
//博客上面设置了调用Window的setStatusBarColor()方法将状态栏设置成透明色
}

*/


/*
* TODO(透明化状态栏，导航栏/沉浸式导航栏，状态栏建议使用，适合splash启动页全屏使用)
* 界面Activity的沉浸式状态栏，使得可以在状态栏显示部分需要的图片
* node: 需要在setContentView之前调用该函数才生效
* */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.transparencyStatusBarAndNavigationBar(){
//    拿到WindowInsetsControllerCompat对象
    val insetsControllerCompat = WindowInsetsControllerCompat(window, window.decorView)
    insetsControllerCompat?.run {
//        隐藏状态栏
        hide(statusBars())
//        隐藏导航栏
        hide(navigationBars())
    }

//    //导航栏隐藏时手势操作
    insetsControllerCompat.systemBarsBehavior = BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
}

/*
* TODO(透明化状态栏/沉浸式状态栏建议使用)
* 界面Activity的沉浸式状态栏，使得可以在状态栏显示部分需要的图片
* node: 需要在setContentView之前调用该函数才生效
* */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.transparencyNavigationBar(){
//    拿到WindowInsetsControllerCompat对象
    val insetsControllerCompat = WindowInsetsControllerCompat(window, window.decorView)
    insetsControllerCompat?.run {

//        隐藏导航栏
        hide(navigationBars())
    }

//    //导航栏隐藏时手势操作
    insetsControllerCompat.systemBarsBehavior = BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
}


/*
* TODO 透明化状态栏颜色和透明度
*
* */
fun Activity.navigationColor(@ColorInt color: Int){
    //当存在导航栏的时候防止导航栏遮住背景图片用的,取代了window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)方法
    window.navigationBarColor = color
    //0xffff00ff是int类型的数据，分组一下0x|ff|ff00ff，0x表示颜色整数的标记，ff表示透明度，f00f表示色值，注意：0x后面ffff00ff必须是8位的颜色表示。1A表示10%透明度
}

/*
* TODO(隐藏软键盘)
*
* */
fun Activity.hideKeyBoard(view: View){
    (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager?)?.run {
        hideSoftInputFromWindow(view.getWindowToken(), 0)
    }
}

/*
* TODO 设置设置状态栏背景颜色(更建议到布局里面修改)
*
* */
fun Activity.userStatusBarColor(activity: Activity, @ColorInt color: Int){
    activity.window?.statusBarColor = color

}

//endregion




