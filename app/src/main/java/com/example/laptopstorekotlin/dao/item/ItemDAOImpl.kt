package com.example.laptopstorekotlin.dao.item

import android.content.Context
import android.util.Log
import com.example.laptopstorekotlin.model.item.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class ItemDAOImpl(private val context: Context) :ItemDAO {

    override fun searchItem(input: String?): ArrayList<Item?>? {
        TODO("Not yet implemented")
    }

    override fun getAllItems(): ArrayList<Item> {
        val jsonFileString = getJsonDataFromAsset(context, "rapidAPIlaptopDB.json")
        print(jsonFileString)
        val gson = Gson()
        val listPersonType = object : TypeToken<ArrayList<Item>>() {}.type
        val items: ArrayList<Item> = gson.fromJson(jsonFileString, listPersonType)
        items.forEachIndexed { idx, item -> Log.i("data", "> Item $idx:\n$item") }
        return items
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}