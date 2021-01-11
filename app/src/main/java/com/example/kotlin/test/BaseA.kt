package com.example.kotlin.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin.R
import com.example.kotlin.ui.login.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class BaseA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        //通过实例启动协程
        MainScope().launch {
            getHome()
        }
    }

    //协程  suspend定义的方法
    suspend fun getHome() {
        val result = get("http://cdplay.cn/api/index")
        Log.d("TAG",result.toString());
    }

    suspend fun get(net: String) = withContext(Dispatchers.IO) {
        /*
         val:  val是一个只读变量，这种声明变量的方式相当于java中的final变量。一个val创建的时候必须初始化，因为以后不能被改变。
         var:  var是一个可变变量，这是一个可以通过重新分配来更改为另一个值的变量。这种声明变量的方式和Java中声明变量的方式一样。 */
        val url = URL(net)
        (url.openConnection() as? HttpURLConnection)?.run {
            requestMethod = "GET"
            setRequestProperty("Content-Type", "application/json;utf-8")
            setRequestProperty("Accept", "application/json")
            //定义接受数据的sb
            var data = StringBuffer()
            //InputStreanReader 读取 httpurlconnection拿到的数据
            val streamReader = InputStreamReader(this.inputStream, "utf-8")
            val reader = BufferedReader(streamReader)   //new BufferedReader(streamReader);  -> java
            //while()->java
            reader.use {
                var temp = it.readLine()  //读取数据的一行
                if (temp != null) data.append(temp)
            }
            reader.close()
            streamReader.close()
            inputStream.close()
            return@run Result.Success(data)

        }
    }
}