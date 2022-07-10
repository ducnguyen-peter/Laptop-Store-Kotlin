package com.example.laptopstorekotlin.view.user.main.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.laptopstorekotlin.R
import com.example.laptopstorekotlin.dao.item.ItemDAOImpl
import com.example.laptopstorekotlin.dao.user.UserDAOImpl
import com.example.laptopstorekotlin.databinding.ActivityMainBinding
import com.example.laptopstorekotlin.model.user.User
import com.example.laptopstorekotlin.utils.PreferenceUtils
import com.example.laptopstorekotlin.view.user.verify.LoginActivity
import com.example.laptopstorekotlin.viewmodel.item.ItemViewModel
import com.example.laptopstorekotlin.viewmodel.item.ItemViewModelFactory

class MainActivity : AppCompatActivity() {
    private val itemViewModel:ItemViewModel by viewModels {
        ItemViewModelFactory(ItemDAOImpl(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val adapter = GridItemAdapter(this, )
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