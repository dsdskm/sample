package com.kkh.sample.kotlin.recipe6

import java.lang.Math.ceil
import java.lang.Math.sqrt


@JvmOverloads
fun main() {
    // https://codechacha.com/ko/kotlin-sequences/
    // 연산이 적은 경우는 collection, 연산이 많은 경우는 sequence
    // 100 부터 200까자의 숫자를 각각 2배로 만든 다음 3으로 나눠떨어지는 첫번째 값 구하기

    var v1 = (100 until 200).map { it * 2 }.filter {
        it % 3 == 0
    }.first()
    println(v1)

    var v2 = (100 until 200).map { it * 2 }.first {
        it % 3 == 0
    }
    println(v2)
    var v3 = (100 until 2_000_000).asSequence().map {
        println("double $it"); it * 2
    }
        .filter { println("filtering $it"); it % 3 == 0 }
        .first()
    println(v3)

    val numSequence1 = sequenceOf(3, 1, 4, 1, 5, 9)
    val numSequence2 = listOf(3, 1, 4, 1, 5, 9).asSequence()

    // 무한 시퀀스
    println(firstNPrimes(111))
    println(primeLessThan(111))

    // 시퀀스 구간 지정
    val fibs = fibonacciSequence().take(10).toList()
    println(fibs)

    val sequence = sequence {
        val start = 0
        yield(start)
        yieldAll(1..5 step 2 )
        yieldAll(generateSequence(8){it*3})
    }// 01,3,5,8,24,72...
    println(sequence)
}

fun fibonacciSequence() = sequence{
    var terms = Pair(0,1)
    while(true){
        yield(terms.first)
        terms = terms.second to terms.first + terms.second
    }
}

fun firstNPrimes(count:Int) = generateSequence(2,::nextPrime).take(count).toList()

fun primeLessThan(max:Int):List<Int> = generateSequence(2){n->if(n<max) nextPrime(n) else null }.toList().dropLast(1)

fun Int.isPrime() = this == 2 || (2..ceil(sqrt(this.toDouble())).toInt()).none { divisor ->
    this % divisor == 0}

fun nextPrime(num:Int) = generateSequence(num+1){it +1 }.first(Int::isPrime)