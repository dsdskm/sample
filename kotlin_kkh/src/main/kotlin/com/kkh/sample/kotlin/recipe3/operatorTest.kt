package com.kkh.sample.kotlin.recipe3

data class Point(val x:Int, val y:Int)

operator fun Point.unaryMinus() = Point(-x,-y)

val point = Point(10,20)

@JvmOverloads
fun main(){
    println(-point);
}