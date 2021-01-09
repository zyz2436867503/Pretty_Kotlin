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
import com.example.kotlin.model.Topic

class TopAdapter(val list: List<Topic>, val context: Context) :
    RecyclerView.Adapter<TopAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_title: TextView = itemView.findViewById(R.id.tv_top_title)
        val tv_price: TextView = itemView.findViewById(R.id.tv_top_price)
        val tv_small: TextView = itemView.findViewById(R.id.tv_top_subtitile)
        val iv_top: ImageView = itemView.findViewById(R.id.iv_top)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.rlv_top_item, parent, false)
        return MyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val top = list.get(position)
        holder.tv_price.setText("￥" + top.price_info + "元起")
        holder.tv_title.setText(top.title)
        holder.tv_small.setText(top.subtitle)
        Glide.with(context).load(top.item_pic_url).into(holder.iv_top)
    }
}