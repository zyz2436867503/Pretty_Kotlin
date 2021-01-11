package com.shop.ext

import android.content.Context
import android.widget.Toast

fun Toast.showTip(context: Context,tips:String){
    Toast.makeText(context,tips,Toast.LENGTH_SHORT).show()
}