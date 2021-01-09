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
import com.example.kotlin.model.Goods

class GoodAdapter(val list: List<Goods>, val context: Context) :
    RecyclerView.Adapter<GoodAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_name: TextView = itemView.findViewById(R.id.tv_good_name)
        val tv_price: TextView = itemView.findViewById(R.id.tv_good_price)
        val iv_good: ImageView = itemView.findViewById(R.id.iv_good)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val good = LayoutInflater.from(context).inflate(R.layout.rlv_good_item, parent, false)
        return MyViewHolder(good)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val good = list.get(position)
        holder.tv_name.setText(good.name)
        holder.tv_price.setText("￥"+good.retail_price)
        Glide.with(context).load(good.list_pic_url).into(holder.iv_good)
    }
}