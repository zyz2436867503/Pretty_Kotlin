package com.example.kotlin.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.BR
import com.example.kotlin.R
import com.example.kotlin.databinding.ActivityNewBindBinding
import com.example.kotlin.viewmodel.NewBindViewModel

class NewBindActivity : AppCompatActivity() {
    var mBinding: ActivityNewBindBinding? = null
    var vm: NewBindViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_bind)
        initVM()
    }

    fun initVM() {
        vm = ViewModelProvider(this).get(NewBindViewModel::class.java)
        vm!!.homeData()
        vm!!.status.observe(this, Observer {
            if (it == 0) {
                mBinding!!.setVariable(BR.bindNewVm, vm)
            }
        })
    }
}