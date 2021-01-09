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
import com.example.kotlin.model.Brand


class BrandAdapter(val list: List<Brand>, val context: Context) :
    RecyclerView.Adapter<BrandAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_ck: TextView = itemView.findViewById(R.id.tv_ck)
        val tv_price: TextView = itemView.findViewById(R.id.tv_price)
        val img_pic: ImageView = itemView.findViewById(R.id.iv_sock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.rlv_brand_item, parent, false)
        return MyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val brand = list.get(position)
        holder.tv_ck.setText(brand.name)
        holder.tv_price.setText(brand.floor_price + "元起")
        Glide.with(context).load(brand.new_pic_url).into(holder.img_pic)

    }
}

