package com.example.laptopstorekotlin.view.user.verify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.laptopstorekotlin.R
import com.example.laptopstorekotlin.dao.item.ItemDAOImpl
import com.example.laptopstorekotlin.dao.user.UserDAOImpl
import com.example.laptopstorekotlin.databinding.ActivityLoginBinding
import com.example.laptopstorekotlin.model.user.User
import com.example.laptopstorekotlin.utils.PreferenceUtils
import com.example.laptopstorekotlin.view.user.main.activities.MainActivity
import com.example.laptopstorekotlin.viewmodel.user.UserViewModel
import com.example.laptopstorekotlin.viewmodel.user.UserViewModelFactory
import java.io.Serializable

class LoginActivity : AppCompatActivity() {
    private val userViewModel:UserViewModel by viewModels {
        UserViewModelFactory(UserDAOImpl(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginViewBinding:ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewBinding.userViewModel = userViewModel

        goToMainPage(User(PreferenceUtils.getName(this)))

        userViewModel.isLoginSuccess.observe(this) { isLoginSuccess: Boolean ->
            if (isLoginSuccess) {
                goToMainPage(User(userViewModel.userIdentity.value))
            }
        }

        loginViewBinding.btnLogin.setOnClickListener{
            userViewModel.checkLogin()
        }
        val itemDAO = ItemDAOImpl(applicationContext)
        itemDAO.getAllItems()
    }

    private fun goToMainPage(user:User){
        if (user.name.isNullOrBlank()) return
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("LoggedInUser", user as Serializable)
        }
        PreferenceUtils.saveName(user.name, this)
        startActivity(intent)
        finish()
    }
}