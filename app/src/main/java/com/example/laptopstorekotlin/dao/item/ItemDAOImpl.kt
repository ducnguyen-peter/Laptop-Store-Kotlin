package com.example.laptopstorekotlin.dao.item

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.laptopstorekotlin.model.item.Item
import com.example.laptopstorekotlin.utils.DBHelper

class ItemDAOImpl(context: Context) :ItemDAO {
    private val dbHelper: DBHelper;
    private val db : SQLiteDatabase;
    init {
        dbHelper = DBHelper(context)
        db = dbHelper.writableDatabase
    }

    override fun searchItem(input: String?): ArrayList<Item?>? {
        TODO("Not yet implemented")
    }

    override fun getAllItems(): ArrayList<Item?>? {
        TODO("Not yet implemented")
    }

}