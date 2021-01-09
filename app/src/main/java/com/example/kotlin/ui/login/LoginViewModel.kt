package com.example.kotlin.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {
    fun login(username: String, password: String) {
        Log.d("TAG", "login: " + Thread.currentThread().name)
        var body = "{username:\"$username\",password:\"$password\"}"
        loginRepository.home(body)

        //创建协程
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG", "login: " + Thread.currentThread().name)
            val jsonBody = "{username:\"$username\",password:\"$password\"}"
            val result = try {
                loginRepository.home(jsonBody)
            } catch (e: Exception) {
                Result.Error(Exception("Newwork request failed"))
            }
            when(result){
                is Result.Success<String> -> Log.d("TAG", "login: "+result.data)
            }
        }
    }
}