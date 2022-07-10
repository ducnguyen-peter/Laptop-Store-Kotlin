package com.example.laptopstorekotlin.viewmodel.item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laptopstorekotlin.dao.item.ItemDAO
import com.example.laptopstorekotlin.dao.item.ItemDAOImpl
import com.example.laptopstorekotlin.model.item.Item

class ItemViewModel(private val itemDAO: ItemDAO):ViewModel() {
    val _listItem = MutableLiveData<ArrayList<Item?>>()
    val listItem:LiveData<ArrayList<Item?>> = _listItem
    fun postItems(){
        Thread{
            _listItem.postValue(itemDAO.getAllItems())
        }.start()
    }
}