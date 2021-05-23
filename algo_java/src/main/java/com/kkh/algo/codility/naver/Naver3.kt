package com.kkh.algo.codility.naver

import java.util.*
import kotlin.math.max

fun main() {
    var arr = IntArray(3)
    arr[0] = 0
    arr[1] = 0
    arr[2] = 0

    println(solution3(arr))
    arr = IntArray(99999)
    for (i in arr.indices) {
        arr[i] = Random().nextInt(10)
    }
    var start = System.currentTimeMillis()
    //println(solution3(arr))
    println("time : ${System.currentTimeMillis() - start}")
}

fun solution3(A: IntArray): Int {
    var res = 0
    if (A.size >= 100000) {
        return -1
    }

    for (i in A.indices) {
        var sum = A[i]
        if (sum == 0) {
            res++
        }
        for (j in i + 1 until A.size) {
            if (sum + A[j] == 0) {
                res++
            }
            sum += A[j]
        }

    }
    return res
}
