package com.example.laptopstorekotlin.model.item

import java.io.Serializable

data class Item(
    val _id: Id,
    val name: String,
    val cpu: CPU,
    val os:String,
    val ram:RAM,
    val screen:Screen,
    val graphicCards: GraphicCards,
    val drives:ArrayList<Drive>,
    val connectivity: Connectivity,
    val interfac:Interface,
    val audio:ArrayList<String>,
    val battery: Battery,
    val dimensions: Dimension,
    val images:ArrayList<String>,
    val url:String,
    val company:String,
    val price:Float,
    val videos:ArrayList<Video>,
    val resizedImage:ResizedImage
) : Serializable
data class Id(val oid:String)
data class CPU(val model:String, val type:String, val company: String, val id:Int, val rank: Int, val url:String, val rating: String): Serializable
data class RAM(val amount: Int): Serializable
data class Screen(val inches:Float, val resolution:String, val refreshRate:Int, val type:String): Serializable
data class GraphicCards(val model: String, val type:String, val company:String, val ram:Int, val id:Int, val rank:Int, val url:String, val rating:String): Serializable
data class Drive(val space:String, val rpm:String, val type:String): Serializable
data class Connectivity(val bluetooth:Boolean, val wifi:String): Serializable
data class Interface(val usb:Int): Serializable
data class Battery(val cells:Int, val watts:Int, val type:String): Serializable
data class Dimension(val dimensions: String, val weight:String): Serializable
data class Video(val id:String, val title:String, val thumbnail:String, val country:String): Serializable
data class ResizedImage(val w150:String, val w300:String, val w60:ArrayList<String>): Serializable