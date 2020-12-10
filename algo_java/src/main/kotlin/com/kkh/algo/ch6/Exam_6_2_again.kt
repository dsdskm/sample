package com.kkh.algo.ch6

@JvmOverloads
fun main() {
    // m개에서 n개를 고르는 재귀 함수
    // [1,2,3,4]
    // 1,2 1,3 1,4
    // 2,3 2,4
    // 3,4
    // 4
    var arr = ArrayList<Int>();
    pick(arr, 4, 2)
}

fun pick(arr: ArrayList<Int>, n: Int, m: Int) {

    // 종료 조건
    if (m == 0) {
        print(arr)
        return
    }

    // 빈배열에 하나씩 추가
    var start = 0
    if (arr.size > 0) {
        // 배열에 값이 있다면 가장 마지막 원소를 시작점으로 해야함
        val len = arr.size
        start = arr[len - 1] + 1
    }

    /*
    0,1 0,2 0,3
        1,2 1,3
            2,0
     */
    //하나씩 넣었다 빼면서 재귀 호출
    for (i in start until n) {
        arr.add(i)
        pick(arr, n, m - 1)
        arr.removeAt(arr.size - 1);
    }

}