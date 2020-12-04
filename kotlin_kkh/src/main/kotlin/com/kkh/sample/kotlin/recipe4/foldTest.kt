package com.kkh.sample.kotlin.recipe4

import java.math.BigInteger

//fold 함수는 배열 또는 반복 가능한 컬렉션에 적용될 수 있는 축약 연산



fun _sum(vararg nums: Int) = nums.fold(0) { acc, n -> acc + n } //  초기값은 0,2개의인자를 받음(누적자의초기값, 두개의 값 연산후 리턴함수
fun _sumWithTrace(vararg nums:Int)=
    nums.fold(0){
        acc,n->
        println("acc = $acc, n = $n")
        acc + n
    }

fun _fact(n:Long):BigInteger=
    when(n){
        0L,1L-> BigInteger.ONE
        else ->(2..n).fold(BigInteger.ONE){
            acc,i->acc*BigInteger.valueOf(i)
        }
    }

@JvmOverloads
fun main(){
    val num = intArrayOf(1,2,3,4)
    println(_sum(1,3,5,7));
    println(_sumWithTrace(1,3,5,7))
    println(_fact(4))
}