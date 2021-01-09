package com.example.kotlin.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin.model.Category


class CateAdapter(val list: List<Category>, val context: FragmentActivity?) :
    RecyclerView.Adapter<CateAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_name: TextView = itemView.findViewById(R.id.cate_name)
        val ryl_cate: RecyclerView = itemView.findViewById(R.id.ry_cate_small)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.rlv_cate_item, parent, false)
        return MyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cate = list.get(position)
        holder.tv_name.setText(cate.name)
        holder.ryl_cate.layoutManager = GridLayoutManager(context, 2)
        holder.ryl_cate.adapter = context?.let { GoodAdapter(cate.goodsList, it) }
    }


}