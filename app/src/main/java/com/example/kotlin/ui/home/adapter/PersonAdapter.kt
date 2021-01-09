package com.example.kotlin.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin.model.HotGoods

class PersonAdapter(val list: List<HotGoods>, val context: Context) :
    RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_name: TextView = itemView.findViewById(R.id.tv_hot_name)
        val tv_price: TextView = itemView.findViewById(R.id.tv_hot_price)
        val tv_brief: TextView = itemView.findViewById(R.id.tv_brief)
        val iv_hot: ImageView = itemView.findViewById(R.id.iv_hot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.rlv_hot_item, parent, false)
        return MyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var hot = list.get(position)
        holder.tv_name.setText(hot.name)
        holder.tv_brief.setText(hot.goods_brief)
        holder.tv_price.setText("￥"+hot.retail_price)
        Glide.with(context).load(hot.list_pic_url).into(holder.iv_hot)
    }
}