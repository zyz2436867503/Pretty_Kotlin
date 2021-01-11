package com.shop.ui.topic

import androidx.fragment.app.Fragment
import com.example.kotlin.R
import com.example.kotlin.databinding.FragmentTopicBinding
import com.shop.base.BaseFragment
import com.shop.viewmodel.topic.TopicViewModel

class TopicFragment:
    BaseFragment<TopicViewModel, FragmentTopicBinding>(R.layout.fragment_topic,TopicViewModel::class.java) {
    companion object{
        val instance by lazy { TopicFragment() }
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