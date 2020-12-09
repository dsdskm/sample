package com.kkh.sample.kotlin.recipe4

import java.math.BigInteger

@JvmOverloads
tailrec fun factorial(n: Long, acc: BigInteger = BigInteger.ONE): BigInteger = when (n) {
    0L -> BigInteger.ONE
    1L -> acc
    else -> factorial(n - 1, acc * BigInteger.valueOf(n))
}

@JvmOverloads
fun main(){
    // 재귀 프로세스를 실행하는 데 필요한 메모리를 최소화
    // 해당 함수가 빠르고 효율적으로 반복
    println(factorial(15000))
}