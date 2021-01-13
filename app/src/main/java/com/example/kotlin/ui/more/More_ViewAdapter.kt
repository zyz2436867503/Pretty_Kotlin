package com.example.kotlin.ui.more

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin.base.BaseAdapter
import com.example.kotlin.model.Stu

class More_ViewAdapter(context: Context, list: List<Stu>, layouts: SparseArray<Int>) :
    BaseAdapter<Stu>(context, list, layouts) {
    override fun layoutId(position: Int): Int {
        var url =  list.get(position).filePathList
        //循环这个集合
        for (i in url.indices){
            val length = url.size
            if(length == 3){
                return R.layout.layout_more_view_item
            }else if(length == 1){
                return R.layout.layout_more_view_item_two
            }
        }
        return R.layout.layout_more_view_item_one
    }

    //刷新条目的数据
    override fun bindData(binding: ViewDataBinding, data: Stu) {
        var url =  data.filePathList
        //循环这个集合
        for (i in url.indices){
            val length = url.size//获取集合长度
            if(length == 3){   //对图片进行赋值
                Glide.with(context).load(url.get(0).filePath).into(binding.root.findViewById(R.id.iv_item_one_img))
                Glide.with(context).load(url.get(1).filePath).into(binding.root.findViewById(R.id.iv_item_two_img))
                Glide.with(context).load(url.get(2).filePath).into(binding.root.findViewById(R.id.iv_item_three_img))
            }else if(length == 1){
                Glide.with(context).load(url.get(0).filePath).into(binding.root.findViewById(R.id.iv_item_one_img_two))
            }
        }
    }

    //刷新加载数据
    fun refreshData(lt : List<Stu>){
        list = lt
        notifyDataSetChanged()
    }

}