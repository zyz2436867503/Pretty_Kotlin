package com.example.kotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shop.IView

abstract class BaseActivity :AppCompatActivity(), IView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)
    }

    protected abstract val getLayout:Int

    override fun showLoading() {

    }
}