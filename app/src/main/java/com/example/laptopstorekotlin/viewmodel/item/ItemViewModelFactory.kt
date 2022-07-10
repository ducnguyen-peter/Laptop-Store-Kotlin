package com.example.laptopstorekotlin.viewmodel.item

import android.widget.ViewSwitcher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.laptopstorekotlin.dao.item.ItemDAO
import com.example.laptopstorekotlin.dao.item.ItemDAOImpl

class ItemViewModelFactory(private val itemDAO: ItemDAO)
    : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(itemDAO) as T;
    }
}