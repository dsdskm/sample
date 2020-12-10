package com.kkh.algo.ch4

import kotlin.math.max

@JvmOverloads
fun main() {
    val arr = arrayOf(-7, 4, -3, 6, 3, -8, 3, 4)

    println(getMaxSum(arr))
}

fun getMaxSum(arr: Array<Int>):Int {
    var psum = 0
    var ret = -999
    for (value in arr){
        psum = max(psum, 0) + value
        // 구간합을 누적한다
        // 기존 구간 합을 0이하가 되지 않도록 갱신한다
        ret = max(psum,ret)
        println("psum = $psum , value = $value, ret = $ret")
    }
    return ret
}
