package com.kkh.algo.ch6

import java.util.*
import kotlin.collections.ArrayList

@JvmOverloads
fun main() {
    // n개의 원소중 m개를 고르는 모든 조합을 찾는 알고리즘(재귀)
    pick(5, ArrayList<Int>(), 3,"  ")

}

fun pick(n: Int, picked: ArrayList<Int>, toPick: Int,space:String) {
    if (toPick == 0) {
        println("$space $picked")
        return
    }
    var smallest = 0
    if (picked.isNotEmpty()) {
        smallest = picked[picked.size - 1] + 1
    }
    println("$space pick : $picked , toPick : $toPick small : $smallest n : $n")
    println("$space for")
    for (next in smallest until n-1) {

        picked.add(next)
        println("$space small : $smallest , next : $next, pick : $picked , toPick : ${toPick-1}")
        pick(n, ArrayList<Int>(picked), toPick - 1,space+"  ")
        picked.removeAt(picked.size - 1)
    }
}