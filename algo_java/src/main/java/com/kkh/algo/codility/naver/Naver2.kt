package com.kkh.algo.codility.naver

import java.util.*
import kotlin.math.max

fun main() {
    var arr = IntArray(5)
    arr[0] = 13
    arr[1] = 7
    arr[2] = 2
    arr[3] = 8
    arr[4] = 3
    println(solution2(arr))

    arr = IntArray(4)
    arr[0] = 1
    arr[1] = 2
    arr[2] = 4
    arr[3] = 8
    println(solution2(arr))
    arr = IntArray(2)
    arr[0] = 16
    arr[1] = 16
    println(solution2(arr))
    arr = IntArray(100000)
    for (i in arr.indices) {
        arr[i] = Random().nextInt(10)
    }
    var start = System.currentTimeMillis()
    println(solution2(arr, false))
    println("time : ${System.currentTimeMillis() - start}")
    start = System.currentTimeMillis()
    println(solution2(arr, true))
    println("time : ${System.currentTimeMillis() - start}")
}

fun solution2(A: IntArray, b: Boolean = false): Int {
    var res = 0
    for (i in A.indices) {
        var sum = A[i]
        var len = if (sum > 0) {
            1
        } else {
            0
        }

        for (j in i + 1 until A.size) {
            val tmp = sum and A[j]
//            println("${sum} ${A[j]} ,res ${res},len $len, j ${j}")
            if (tmp > 0) {
                sum = tmp
                len++
            }
            //println("${sum} ${A[j]} ,res ${res},diff ${A.size - j + len}")
            if (res != 0 && A.size - j + len < res) {
                break
            }
        }
        res = max(len, res)
    }
    return res
}
