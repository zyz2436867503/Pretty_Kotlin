package com.example.kotlin.viewmodel.more

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.base.BaseViewModel
import com.example.kotlin.model.Stu
import com.example.kotlin.net.repository.Injection

import com.google.gson.Gson


import kotlinx.coroutines.launch

class MoreViewModel  : BaseViewModel(Injection.repository){
    //采用MutableLiveData进行修饰 并进行实例化
    var stu : MutableLiveData<List<Stu>> = MutableLiveData(listOf())

    //TODO 获取数据
    fun getMore(){//协程
        viewModelScope.launch {
            var results= repository.getMore()
            Log.e("TAG", "getMore: "+results )
   if(results.status.statusCode == 100){
                stu.postValue(results.data.list)
           }
        }
    }
}
