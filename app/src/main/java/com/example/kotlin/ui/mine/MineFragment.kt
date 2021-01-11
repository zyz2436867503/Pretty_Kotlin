package com.example.kotlin.ui.mine

import com.example.kotlin.R
import com.example.kotlin.databinding.FragmentMineBinding
import com.example.kotlin.viewmodel.mine.MineViewModel
import com.shop.base.BaseFragment
import com.shop.ui.topic.TopicFragment

class MineFragment:BaseFragment<MineViewModel,FragmentMineBinding>(R.layout.fragment_mine,MineViewModel::class.java) {
    companion object{
        val instance by lazy { MineFragment() }
    }

    override fun initView() {

    }

    override fun initVM() {
    }

    override fun initData() {
    }

    override fun initVariable() {
    }
}