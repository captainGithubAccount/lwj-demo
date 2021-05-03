package com.lwj.common.ktx

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.*
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner


//region 扩展属性
/*
*  TODO(扩展lifeCycleOwner属性，便于和Fragment之间使用lifeCycleOwner一致性)
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

/*
* TODO(透明化状态栏/沉浸式状态栏建议使用)
* 界面Activity的沉浸式状态栏，使得可以在状态栏显示部分需要的图片
* node: 需要在setContentView之前调用该函数才生效
* */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.transparencyStatusBar(view: View){
    window?.apply {
        addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        //可以尝试删掉前两行试试
        statusBarColor = Color.TRANSPARENT
        //取代了addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        insetsController?.run {
            hide(WindowInsets.Type.statusBars())
            hide(WindowInsets.Type.navigationBars())
        }
        //取代了decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
    // Hide the status bar.
//博客上面设置了调用Window的setStatusBarColor()方法将状态栏设置成透明色
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


//endregion




