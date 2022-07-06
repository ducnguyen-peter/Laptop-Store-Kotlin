package com.example.laptopstorekotlin.utils

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DBHelper(
    context: Context?
) : SQLiteAssetHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        const val DATABASE_NAME = "mobile.db"
        const val DATABASE_VERSION = 1
    }
}