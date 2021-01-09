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
import com.example.kotlin.model.NewGoods

class NewAdapter(val list: List<NewGoods>, val context: Context) :
    RecyclerView.Adapter<NewAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_new: TextView = itemView.findViewById(R.id.tv_new_home)
        val tv_price: TextView = itemView.findViewById(R.id.tv_price_home)
        val iv_new: ImageView = itemView.findViewById(R.id.iv_new_home)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewAdapter.MyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.rlv_new_item, parent, false)
        return MyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewAdapter.MyViewHolder, position: Int) {
        var newlist = list.get(position)
        holder.tv_new.setText(newlist.name)
        holder.tv_price.setText("￥" + newlist.retail_price)
        Glide.with(context).load(newlist.list_pic_url).into(holder.iv_new)
    }
}