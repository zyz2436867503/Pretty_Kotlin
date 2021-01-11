package com.example.kotlin.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.R
import com.example.kotlin.viewmodel.HomeViewModel

class VHomeActivity : AppCompatActivity() {
    lateinit var homeVM: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

        initVm()
        homeVM.loadHomeData()
    }

    private fun initVm() {
        //初始化ViewModel
        ViewModelProvider(this).get(HomeViewModel::class.java)

        //监听网络状态的变化
        homeVM.loadStatue.observe(this, Observer {status->
            if(status==-1){
                Log.i("TAG", "initVm: 数据加载失败")
            }

        })

        /**
         * 监听轮播图数据的变化
         */
        homeVM.banner.observe(this, Observer { banner->
            Log.i("TAG", "initVm: banner")
        })
    }
}