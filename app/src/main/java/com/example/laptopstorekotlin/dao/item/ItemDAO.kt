package com.example.laptopstorekotlin.dao.item

import com.example.laptopstorekotlin.model.item.Item

interface ItemDAO {
    fun searchItem(input: String?): ArrayList<Item?>?
    fun getAllItems(): ArrayList<Item>?
}