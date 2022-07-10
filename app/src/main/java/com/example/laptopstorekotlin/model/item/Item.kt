package com.example.laptopstorekotlin.model.item

data class Item(
    val id: String,
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
)
data class CPU(val model:String, val type:String, val company: String, val id:Int, val rank: Int, val url:String, val rating: String)
data class RAM(val amount: Int)
data class Screen(val inches:Float, val resolution:String, val refreshRate:Int, val type:String)
data class GraphicCards(val model: String, val type:String, val company:String, val ram:Int, val id:Int, val rank:Int, val url:String, val rating:String)
data class Drive(val space:String, val rpm:String, val type:String)
data class Connectivity(val bluetooth:Boolean, val wifi:String)
data class Interface(val usb:Int)
data class Battery(val cells:Int, val watts:Int, val type:String)
data class Dimension(val dimensions: String, val weight:String)
data class Video(val id:String, val title:String, val thumbnail:String, val country:String)
data class ResizedImage(val w150:String, val w300:String, val w60:ArrayList<String>)