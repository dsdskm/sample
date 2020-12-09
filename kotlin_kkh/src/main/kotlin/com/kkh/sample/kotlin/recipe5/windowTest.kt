package com.kkh.sample.kotlin.recipe5

@JvmOverloads
fun main(){

    val range =0..10
    val chunked = range.chunked(3)
    println(chunked)

    val windowed = range.windowed(3,1)
    println(windowed)

    val list = listOf("a","b","c","d","e","f","g")
    val (a,b,c,d,e) = list
    println("$a $b $c $d $e");
}