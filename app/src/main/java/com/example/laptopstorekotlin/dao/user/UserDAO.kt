package com.example.laptopstorekotlin.dao.user

import com.example.laptopstorekotlin.model.user.User

interface UserDAO {
    fun addUser(user: User)
    fun checkLogin(identity: String?, password: String?): Boolean
}