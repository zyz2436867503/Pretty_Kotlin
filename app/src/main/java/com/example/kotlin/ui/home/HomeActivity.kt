package com.example.kotlin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin.model.*
import com.example.kotlin.ui.home.adapter.*
import com.example.kotlin.utils.TxtUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_channel_item.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadHomeData()

    }

    private fun loadHomeData() {
        //当前线程的属性：hread.currentThread().name
        var thread_name = Thread.currentThread().name
        //启动协程
        MainScope().launch {
            var thread_name1 = Thread.currentThread().name
            var result = HomeBean()
            Log.i("TAG", "loadHomeData: " + result.errmsg)
            showBanner(result.data.banner)        //banner
            showchannel(result.data.channel)      //导航
            showBrandList(result.data.brandList)  //品牌列表
            showNewList(result.data.newGoodsList) //新品首发
            showPerson(result.data.hotGoodsList)  //人气推荐
            showTop(result.data.topicList)        //专题精选
            showCate(result.data.categoryList)    //居家
        }
        Log.d("TAG", "loadHomeData: ")

    }

    private fun showCate(categoryList: List<Category>) {
        ry_live_cate.layoutManager=GridLayoutManager(this,1)
        ry_live_cate.adapter=CateAdapter(categoryList,this)
    }

    private fun showTop(topicList: List<Topic>) {
        ry_top.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        ry_top.adapter = TopAdapter(topicList, this)
    }

    //人气推荐
    private fun showPerson(hotGoodsList: List<HotGoods>) {
        ry_person.layoutManager = GridLayoutManager(this, 1)
        ry_person.adapter = PersonAdapter(hotGoodsList, this)
        ry_person.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

    }

    //品牌列表
    private fun showNewList(newGoodsList: List<NewGoods>) {
        ry_monday.layoutManager = GridLayoutManager(this, 2)
        ry_monday.adapter = NewAdapter(newGoodsList, this)
    }


    //品牌列表
    private fun showBrandList(brandList: List<Brand>) {
        ry_home.layoutManager = GridLayoutManager(this, 2)
        ry_home.adapter = BrandAdapter(brandList, this)
    }

    //显示导航栏
    private fun showchannel(channel: List<Channel>) {
        layout_tab.removeAllViews()
        var layoutchannel = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1F)
        channel!!.forEach {
            var inflate =
                LayoutInflater.from(this).inflate(R.layout.layout_channel_item, layout_tab, false)
            Glide.with(this).load(it.icon_url).into(inflate.img_channel)
            TxtUtils.setTextView(inflate.txt_channel, it.name)
            inflate.txt_channel.setGravity(Gravity.CENTER)
            inflate.setLayoutParams(layoutchannel)
            layout_tab.addView(inflate)
        }
    }

    //显示banner
    private fun showBanner(banners: List<Banner>) {
        banner_home!!.setImages(banners)
        banner_home!!.setImageLoader(MyBannerAdapter())
        banner_home!!.start()
    }

    suspend fun HomeBean(): HomeBean {
        var url = "https://cdplay.cn/api/index"
        return get(url)
    }

    suspend fun get(netUrl: String) = withContext(Dispatchers.IO) {
        var url = URL(netUrl)
        (url.openConnection() as? HttpsURLConnection).run {
            var sb = StringBuffer()
            /*
            * ?.意思是这个参数可以为空,并且程序继续运行下去
            * !!.的意思是这个参数如果为空,就抛出异常
            * */
            var streamReader = InputStreamReader(this!!.inputStream, "utf-8")
            var reader = BufferedReader(streamReader)
            reader.use {
                var temp = reader.readLine()
                if (temp != null) sb.append(temp)
            }
            streamReader.close()
            reader.close()
            inputStream.close()
            //gson解析
            val homebean = Gson().fromJson<HomeBean>(sb.toString(), HomeBean::class.java)
            return@run homebean
        }
    }


}