package com.example.kotlin.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.shop.test.IView

/**
 * baseactivity基类
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(
    var layoutId: Int,
    val vmClass: Class<VM>
) : AppCompatActivity(),
    IView {
    protected lateinit var mViewModel: VM
    protected lateinit var mDataBinding: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, getLayout)
        mViewModel = ViewModelProvider(this).get(vmClass)
        initView()
        initVM()
        initData()
        initVariable()
    }

    protected abstract fun initView()
    protected abstract fun initVM();
    protected abstract fun initData()
    protected abstract fun initVariable()

    protected abstract val getLayout: Int

    override fun showTips(tips: String) {
        Toast.makeText(this, tips, Toast.LENGTH_SHORT).show()
    }
}