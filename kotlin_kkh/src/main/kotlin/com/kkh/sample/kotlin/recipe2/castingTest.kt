package com.kkh.sample.kotlin.recipe2

class castingTest {
}

fun test(){

    //toInt,toLong으로 직접 캐스팅

    var intA:Int = 10
    var longB:Long = intA.toLong()
    //var longC:Long = intA

    var longA:Long = 10
    //var intB:Int = longA
    var intC:Int = longA.toInt()

    42.toString(2)//"101010"
}
