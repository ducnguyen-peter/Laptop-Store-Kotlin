package com.example.laptopstorekotlin.viewmodel.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.laptopstorekotlin.dao.user.UserDAO

class UserViewModelFactory(private val userDAO: UserDAO)
    :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userDAO) as T
    }
}