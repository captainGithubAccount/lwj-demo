package com.lwj.common.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


abstract class BaseFragment: Fragment {//当直接:Fragment时,而不是:Fragment()，需要指明构造器constructor([...])
    constructor(): super()
    constructor(@LayoutRes layout: Int):super(layout)

    /*
   * TODO(扩展liveData的observer函数)
   * */
    protected fun<T: Any> LiveData<T>.observerKt(block: (T?) -> Unit){
        //传入一个函数，这个函数用来处理更新ui的操作
        this.observe(viewLifecycleOwner,  Observer<T> { observerData ->
            // Update the UI, in this case, a TextView.
            block.invoke(observerData)
        })
    }
}