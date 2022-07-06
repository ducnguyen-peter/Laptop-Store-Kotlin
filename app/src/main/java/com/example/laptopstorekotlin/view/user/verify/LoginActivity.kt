package com.example.laptopstorekotlin.view.user.verify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.laptopstorekotlin.R
import com.example.laptopstorekotlin.dao.user.UserDAOImpl
import com.example.laptopstorekotlin.databinding.ActivityLoginBinding
import com.example.laptopstorekotlin.model.user.User
import com.example.laptopstorekotlin.viewmodel.user.UserViewModel
import java.io.Serializable

class LoginActivity : AppCompatActivity() {
    val userDAO = UserDAOImpl(this)
    val userViewModel = UserViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginViewBinding:ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        loginViewBinding.userViewModel = userViewModel
        var isLoginSuccess = false
        loginViewBinding.btnLogin.setOnClickListener{
            Thread{
                isLoginSuccess = userDAO.checkLogin(userViewModel.userIdentity.value, userViewModel.password.value)
            }.start()
            println("Login sucess: $isLoginSuccess")
            if(isLoginSuccess){
                println("Launch activity")
                userViewModel.user.value = User()
                userViewModel.user.value?.name = userViewModel.userIdentity.value
                userViewModel.user.value?.password = userViewModel.password.value
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("LoggedInUser", userViewModel.user.value as Serializable)
                }
                startActivity(intent)
            }
        }
    }
}