package com.example.laptopstorekotlin.view.user.verify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.laptopstorekotlin.R
import com.example.laptopstorekotlin.dao.user.UserDAOImpl
import com.example.laptopstorekotlin.databinding.ActivityLoginBinding
import com.example.laptopstorekotlin.model.user.User
import com.example.laptopstorekotlin.viewmodel.user.UserViewModel
import com.example.laptopstorekotlin.viewmodel.user.UserViewModelFactory
import java.io.Serializable

class LoginActivity : AppCompatActivity() {
    private val userViewModel:UserViewModel by viewModels<UserViewModel> {
        UserViewModelFactory(UserDAOImpl(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginViewBinding:ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        loginViewBinding.userViewModel = userViewModel

        val userObserver = Observer<Boolean>{ isLoginSuccess:Boolean->
            if(isLoginSuccess){
                val user = User(userViewModel.userIdentity.value,userViewModel.password.value)
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("LoggedInUser", user as Serializable)
                }
                startActivity(intent)
                finish()
            }
        }
        userViewModel.isLoginSuccess.observe(this, userObserver)

        loginViewBinding.btnLogin.setOnClickListener{
            userViewModel.checkLogin()
        }
    }
}