package com.kkh.sample.kotlin.recipe8

// 어떤 속성이 필요할 때까지 해당 속성의 초기화를 지연

val ultimateAnswer: Int by lazy {
    println("computing the answer")     // only one printed
    42
}

@JvmOverloads
fun main(){
    println(ultimateAnswer)
    println(ultimateAnswer)
}