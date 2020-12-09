package com.kkh.sample.kotlin.recipe5

val min = 2
val max = 6

@JvmOverloads
fun main(){
    println(5.coerceIn(min,max))
    println(10.coerceIn(min,max))
    println(1 .coerceIn(min,max))
}