package com.example.kotlin.base

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open abstract class BaseAdapter<D>(
    val context: Context, var list: List<D>,
    val layouts: SparseArray<Int>
   // var clicks: SparseArray<Int>
) : RecyclerView.Adapter<BaseAdapter<D>.BaseVH>() {
    /**
     * 用来初始化创建ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {
        var dataBinding: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return BaseVH(dataBinding)

        //return BaseVH(DataBindingUtil.inflate(LayoutInflater.from(parent.context),viewType,parent,false))
    }

    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        //获取当前条目布局的id
        var layoutId = getItemViewType(position)
        //获取layout id所对应的BR的id
        var type = layouts.get(layoutId)
        holder.dataBinding.setVariable(type, list.get(position))
        holder.dataBinding.root.tag = position
       /* if (clicks.size() > 0) {
            var brname = clicks[0]
        }*/
        bindData(holder.dataBinding, list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return layoutId(position)
    }

    /**
     * 获取对应的布局
     */
    protected abstract fun layoutId(position: Int): Int

    protected abstract fun bindData(binding: ViewDataBinding, data: D)
    inner class BaseVH(val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root)

}