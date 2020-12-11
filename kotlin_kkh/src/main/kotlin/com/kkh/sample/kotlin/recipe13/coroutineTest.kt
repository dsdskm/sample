package com.kkh.sample.kotlin.recipe13

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@JvmOverloads
fun main() {

    // runBlocking 빌더
    // 현재 스레드를 블록하고 모든 내부 코루틴이 종료될 때까지 블록
    println("Before runBlocking")
    runBlocking {
        print("Hello, ")
        delay(200L)
        println("World!")
    }
    println("After runBlocking")

    // 독립된 프로세스를 실행하는 코루틴을 시작하고, 해당 코루틴에서 리턴값을 받을 필요가 없다면 launch 코루틴 빌더 사용
    println("===========================")
    println("Before runBlocking")
    runBlocking {
        println("Before launch")
        launch {
            print("Hello, ")
            delay(200L)
            println("World!")
        }
        println("After launch")
    }
    println("After runBlocking")
}