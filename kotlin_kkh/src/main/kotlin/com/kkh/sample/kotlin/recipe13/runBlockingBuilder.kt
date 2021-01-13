package com.kkh.sample.kotlin.recipe13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@JvmOverloads
fun main() {
    /*
    현재 스레드를 블록하고 모든 내부 코루틴이 종료될 때까지 블록
     */
    println("Before creating coroutine")
    runBlocking {
        println("Hello")
        delay(5000L)
        println("World")
    }
    println("After coroutine")
}