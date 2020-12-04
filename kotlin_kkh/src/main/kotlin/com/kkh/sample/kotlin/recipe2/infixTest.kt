package com.kkh.sample.kotlin.recipe2

import kotlin.math.pow

infix fun Int.`^2`(x: Int) = toDouble().pow(x).toInt()
infix fun Long.`**`(x: Int) = toDouble().pow(x).toLong()
infix fun Float.`**`(x: Int) = pow(x)
infix fun Double.`**`(x: Int) = pow(x)

fun Int.pow(x: Int) = `^2`(x)
fun Long.pow(x: Int) = `**`(x)

@JvmOverloads
fun main(){
    println("main")

    // infix 함수는 두개의 변수 가운데 오는 함
    var intA = 10
    val res = intA.pow(2)

    println("$intA ** 2 = $res")

    val map = mapOf("a" to 1, "b" to 2, "c" to 2)
    println(map["a"])
    println(map["b"])
    println(map["c"])
}