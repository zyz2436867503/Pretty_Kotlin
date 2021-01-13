package com.example.kotlin.api

import com.example.kotlin.model.HomeBean
import com.example.kotlin.model.TongpaoBean
import com.example.kotlin.model.TopicBean
import com.shop.net.BaseResp
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApi {

    //刷新token
    @POST("auth/refreshToken")
    suspend fun refreshToken(): BaseResp<String>

    //BaseResp抽取的一个bean类的外层结构 homeBean当前接口返回的具体
    @GET("index")
    suspend fun getHome(): BaseResp<HomeBean>

    //专题
    @GET("topic/list?page=1&size=10")
    suspend fun getTopic(): BaseResp<TopicBean>

    //多布局的接口
    @GET("discover/hot.json")
    suspend fun getMore(): TongpaoBean
}