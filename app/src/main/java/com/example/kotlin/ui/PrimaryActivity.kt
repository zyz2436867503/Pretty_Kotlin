package com.example.kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.kotlin.R
import com.example.kotlin.ui.home.fragment.HomeFragment
import com.shop.ui.home.fragment.MeFragment
import com.shop.ui.home.fragment.ShopFragment
import com.shop.ui.home.fragment.SortFragment
import com.shop.ui.home.fragment.TopicFragment
import kotlinx.android.synthetic.main.activity_all.*


class PrimaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all)
        initView()
    }

    //定义方法
    fun initView() {

        val fragments = arrayListOf<Fragment>()

        fragments.add(HomeFragment())
        fragments.add(TopicFragment())
        fragments.add(SortFragment())
        fragments.add(ShopFragment())
        fragments.add(MeFragment())

        //设置适配器
        vp_primary!!.adapter = ViewPage(supportFragmentManager, fragments)
        //绑定
        tab_paimary.setupWithViewPager(vp_primary)

        var listName = arrayOf("首页", "专题", "分类", "购物车", "我的")
        val icon = arrayOf(
            R.drawable.selector_home,
            R.drawable.selector_topic,
            R.drawable.selector_sort,
            R.drawable.selector_shoping,
            R.drawable.selector_me
        )
        //设置tab数据
        for (i in fragments.indices) {
            tab_paimary.getTabAt(i)?.setText(listName[i])?.setIcon(icon[i])
        }
    }

}

class ViewPage(supportFragmentManager: FragmentManager, var fragments: ArrayList<Fragment>) :
    FragmentStatePagerAdapter(supportFragmentManager) {
    override fun getItem(position: Int): Fragment {
        return fragments?.get(position)
    }

    override fun getCount(): Int {
        return fragments?.size ?: 0
    }

}
