package com.kkh.sample.kotlin.recipe7

// 코드 흐름을 방해하지 않고 메시지를 출력하거나 다른 부수 효과를 생성

@JvmOverloads
fun main(){

    val value = createBook().also {
        println("it is $it")
    }.also {
        println("it is second $it")
    }
}

fun createBook():String{
    return "BOOK"
}