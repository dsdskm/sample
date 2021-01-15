package com.kkh.sample.kotlin.recipe13

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking{
    val time = measureTimeMillis {
        val one = async{doSomethingUsefulOne()}
        val two = async{doSomethingUsefulTwo()}
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}