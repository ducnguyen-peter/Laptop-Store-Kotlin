package com.example.laptopstorekotlin.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.laptopstorekotlin.R

class PreferenceUtils {
    companion object{
        fun saveName(name:String?, context:Context){
            val preferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            with(preferences.edit()){
                putString(KEY_USERNAME, name)
                apply()
            }
        }
        fun getName(context: Context) : String?{
            val preferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            return preferences.getString(KEY_USERNAME, null)
        }
    }

}