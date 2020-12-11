package com.kkh.sample.kotlin.recipe7

// 널이 아닌 레퍼런스의 코드 블록을 실행하고, 레퍼런스가 널이면 기본값을 리턴

@JvmOverloads
fun main() {
    println(processString(""))
    println(processString("_"))
    println(processString("aAa"))

    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let {
        println(it)
    }
    numbers.map { it.length }.filter { it > 3 }.let(::println)
}

fun processString(str: String) = str.let {
    when {
        it.isEmpty() -> "Empty"
        it.isBlank() -> "Blank"
        else -> it.capitalize()
    }
}