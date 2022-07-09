package com.example.laptopstorekotlin.model.item

data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val unitPrice: Float,
    val quantity: Int,
    val imageLink: String
)
