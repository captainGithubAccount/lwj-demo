package com.lwj.common.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.lwj.common.ktx.viewLifeCycleOwner

abstract class  BaseActivity: AppCompatActivity {
    constructor(): super()
    constructor(@LayoutRes layout: Int):super(layout)

    /*
    * TODO 扩展liveData的observer函数
    * */
    protected fun<T: Any> LiveData<T>.observerKt(block: (T?) -> Unit){
        //传入一个函数，这个函数用来处理更新ui的操作
        this.observe(viewLifeCycleOwner,  Observer<T> { observerData ->
            // Update the UI, in this case, a TextView.
            block.invoke(observerData)
        })
    }
}