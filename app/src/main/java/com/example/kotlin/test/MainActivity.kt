package com.example.kotlin.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //写全局必须初始化 下面这个没有初始化
    // var m_a:Int    //可以做一个延迟初始化
    // ：后面是类型 类型后面的？ ？代表对应的变量/类没有初始化可能为空
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
        initView()
    }

    fun test() {

        //可变参数
        var name = "apple"
        print(name)

        //lambda函数(匿名函数)
        //参数的格式为 参数:类型
        //定义一个sum函数 a b表示变量
        //val 定义常量和变量 不可更改 类似final
        val sum: (Int, Int) -> Int = { a, b -> a + b }
        //int a,int b a+b=1+2
        print(sum(1, 2))   //输出3


        //外部类
        Green("" + sum(1, 2)).grn()

        //var 定义一个可变的变变量
        var c: Int
        //可以根据值反推回去什么类型 弱类型语言(可以不用给他类型)
        var b = 1.0

        //字符串的

    }

    //外部类
    class Green(var name: String) {
        fun grn() {
            Log.e("TAG", "grn:$name")// 成员函数
        }
    }

    fun initView() {
        bt_submit.setOnClickListener({ v ->
            val intent = Intent();
            intent.setClass(this, MainActivity2::class.java)
            startActivity(intent)
        })
    }


}