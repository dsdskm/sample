package com.kkh.sample.kotlin.recipe4

// reduce 함수는 fold함수와 비슷한데 누적자의 초기값이 없다

fun sumReduce(vararg nums: Int) =
    nums.reduce { acc, i -> acc + i }

@JvmOverloads
fun main() {
    println()
}