package com.example.laptopstorekotlin.viewmodel.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laptopstorekotlin.model.user.User

class UserViewModel : ViewModel() {
    val userIdentity = MutableLiveData<String?>()
    val password = MutableLiveData<String?>()
    val user:MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
}