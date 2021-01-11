package com.example.kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.kotlin.model.Brand
import com.example.kotlin.model.HomeBean
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class BindHomeViewModel {
    var brand: MutableLiveData<List<Brand>> = MutableLiveData(listOf())
    fun homeData() {
        GlobalScope.launch {
            loadData()
        }
    }

    suspend fun loadData() {
        var homeData = get("https://cdplay.cn/api/index")
        if (homeData != null) {
            brand.postValue(homeData.data.brandList)
        } else {
        }
    }

    /**
     * 网络请求
     */
    suspend fun get(str: String) = withContext(Dispatchers.IO) {
        var result = URL(str).readText(charset("utf-8"))
        return@withContext Gson().fromJson<HomeBean>(result, HomeBean::class.java)
    }
}