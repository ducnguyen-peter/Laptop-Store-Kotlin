package com.example.laptopstorekotlin.learning

fun main() {
    val data1 = TestData("1")
    val data2 = TestData("1")

    println("data1 == data2: ${data1 == data2}")


    val map = HashSet<TestData>()
    map.add(data1)
    map.add(data2)

    println("size: ${map.size}")

    val test1 = TestGeneric("1")

    val a = with(test1) {
        param1
    }

//    1: let
//    input: it
//    output: lenh cuoi cung

    //    2: also
//    input: it
//    output: this


    //    3: run
//    input: this
//    output: lenh cuoi cung

    //    4: apply
//    input: this
//    output: this
}