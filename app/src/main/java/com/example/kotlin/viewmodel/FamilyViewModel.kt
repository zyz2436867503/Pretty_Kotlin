package com.example.kotlin.viewmodel

import androidx.fragment.app.Fragment
import com.example.kotlin.base.BaseViewModel
import com.example.kotlin.net.repository.Injection
import com.example.kotlin.ui.home.HousePageFragment
import com.example.kotlin.ui.mine.MineFragment
import com.shop.ui.car.ShopFragment
import com.shop.ui.sort.SortFragment
import com.shop.ui.topic.TopicFragment

class FamilyViewModel : BaseViewModel(Injection.repository) {
    var fragments: MutableList<Fragment> = mutableListOf()

    init {
        fragments.add(HousePageFragment.instance)
        fragments.add(TopicFragment.instance)
        fragments.add(SortFragment.instance)
        fragments.add(ShopFragment.instance)
        fragments.add(MineFragment.instance)
    }
}