package com.example.kotlin.net.repository

import com.example.kotlin.api.ServiceApi
import com.shop.net.RetrofitFactory
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*
数据仓库
用来连接ViewModel 和 Model
定义业务相关的网络请求接口的api
* */
class SystemRepository {
    private lateinit var serviceApi: ServiceApi

    //初始化的方法
    init {
        serviceApi = RetrofitFactory.instance.create(ServiceApi::class.java)
    }

    //刷新token
    suspend fun refreshToken() = withContext(Dispatchers.IO) {
        serviceApi.refreshToken()
    }

    /**
     * 获取主页数据
     */
    suspend fun getHome() = withContext(Dispatchers.IO) {
        serviceApi.getHome()
    }

    /**
     * 获取专题数据
     */
    suspend fun getTopic() = withContext(Dispatchers.IO) {
        serviceApi.getTopic()
    }

    //TODO 获取多布局数据
    suspend fun getMore() = withContext(Dispatchers.IO) {
        serviceApi.getMore()
    }
}