package com.example.kotlin.ui.more

import android.util.SparseArray
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.BR
import com.example.kotlin.R
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityMoreViewBinding
import com.example.kotlin.model.Stu
import com.example.kotlin.viewmodel.more.MoreViewModel
import kotlinx.android.synthetic.main.activity_more_view.*

class MoreActivity : BaseActivity<MoreViewModel, ActivityMoreViewBinding>(
    R.layout.activity_more_view,
    MoreViewModel::class.java
) {
    //lateinit 延迟初始化
    lateinit var adapter: More_ViewAdapter
    var list: List<Stu> = arrayListOf()
    override fun initView() {
//设置布局管理器
        val layoutManager = LinearLayoutManager(this)
        mDataBinding!!.mRlvMoreView.layoutManager = layoutManager
    }

    override fun initVM() {
        //观察者模式
        mViewModel.stu.observe(this, Observer {
            adapter!!.refreshData(it)
        })
    }

    override fun initData() {
        mViewModel.getMore()

        //封装xml布局界面的id和界面中需要绑定的数据对应的id
        var array = SparseArray<Int>()
        array.put(R.layout.layout_more_view_item, BR.vmMore_View)
        array.put(R.layout.layout_more_view_item_one, BR.vmMore_View_one)
        array.put(R.layout.layout_more_view_item_two, BR.vmMore_View_two)

        adapter = More_ViewAdapter(this, list, array)
        //绑定适配器
        mDataBinding!!.mRlvMoreView.adapter = adapter

        mRlv_More_View!!.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
    }

    override fun initVariable() {

    }

    override val getLayout: Int
        get() = R.layout.activity_more_view

    override fun showLoading() {

    }

}