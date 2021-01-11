package com.shop.ui.car

import androidx.fragment.app.Fragment
import com.example.kotlin.R
import com.shop.base.BaseFragment
import com.example.kotlin.base.BaseViewModel
import com.example.kotlin.databinding.FragmentShopBinding
import com.example.kotlin.net.repository.Injection

import com.shop.viewmodel.shop.ShopViewModel

class ShopFragment(val lid: Int) :
    BaseFragment<ShopViewModel, FragmentShopBinding>(lid, ShopViewModel::class.java) {
    companion object {
        val instance by lazy { ShopFragment(R.layout.fragment_shop) }
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