package com.example.kotlin

import android.content.Intent
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivitySplaceBinding
import com.example.kotlin.test.MainActivity
import com.example.kotlin.viewmodel.SplaceViewModel

class SplaceActivity : BaseActivity<SplaceViewModel, ActivitySplaceBinding>(
    R.layout.activity_splace,
    SplaceViewModel::class.java
) {
    override fun initView() {
        var intent = Intent(this, FamilyActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }


    override fun showLoading() {

    }

    override fun showTips(tips: String) {

    }

    override val getLayout: Int
        get() = R.layout.activity_splace


}