package com.example.laptopstorekotlin.view.user.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.laptopstorekotlin.R
import com.example.laptopstorekotlin.learning.TestData
import com.example.laptopstorekotlin.databinding.ActivityMainBinding
import com.example.laptopstorekotlin.model.user.User
import com.example.laptopstorekotlin.utils.PreferenceUtils
import com.example.laptopstorekotlin.view.user.verify.LoginActivity

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemLogOut->{
                PreferenceUtils.saveName(null, this)
                val intent = Intent(this, LoginActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                startActivity(intent)
                finish()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

}