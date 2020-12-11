package com.kkh.sample.kotlin.recipe10

import java.io.File

fun get0LongestWordsInDictionary() = File("/usr/share/dict/words").useLines { line ->
    line.filter {
        it.length > 20
    }.sortedByDescending(
        String::length
    ).take(10)
        .toList()
}

@JvmOverloads
fun main(){
    val a = get0LongestWordsInDictionary()
    println(a)

}