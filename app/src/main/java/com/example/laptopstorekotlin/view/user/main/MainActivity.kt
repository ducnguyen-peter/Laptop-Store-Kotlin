package com.example.laptopstorekotlin.view.user.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.laptopstorekotlin.R
import com.example.laptopstorekotlin.learning.TestData
import com.example.laptopstorekotlin.databinding.ActivityMainBinding
import com.example.laptopstorekotlin.model.user.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginViewBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val user = if(intent.hasExtra("LoggedInUser")){
            intent.getSerializableExtra("LoggedInUser") as User
        } else User("")
        loginViewBinding.textView2.text = "Welcome ${user.name}"
    }

}