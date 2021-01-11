package com.shop.ui.sort

import androidx.fragment.app.Fragment
import com.example.kotlin.R
import com.example.kotlin.databinding.FragmentSortBinding
import com.shop.base.BaseFragment
import com.shop.viewmodel.sort.SortViewModel


class SortFragment:
    BaseFragment<SortViewModel, FragmentSortBinding>(R.layout.fragment_sort,SortViewModel::class.java) {
    companion object{
        val instance by lazy { SortFragment() }
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