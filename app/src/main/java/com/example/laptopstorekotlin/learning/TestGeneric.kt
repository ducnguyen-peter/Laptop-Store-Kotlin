package com.example.laptopstorekotlin.learning

class TestGeneric<T>(
    val param1: T
) {

    fun print() {
        println(param1)
    }
}