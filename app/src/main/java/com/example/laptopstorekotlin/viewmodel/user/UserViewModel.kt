package com.example.laptopstorekotlin.viewmodel.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laptopstorekotlin.dao.user.UserDAO

class UserViewModel(private val userDAO:UserDAO) : ViewModel() {
    val userIdentity = MutableLiveData<String?>()
    val password = MutableLiveData<String?>()
    private val _isLoginSuccess = MutableLiveData(false)
    val isLoginSuccess:LiveData<Boolean> = _isLoginSuccess
    fun checkLogin(){
        Thread{
            _isLoginSuccess.postValue(userDAO.checkLogin(userIdentity.value, password.value))
        }.start()
    }
}