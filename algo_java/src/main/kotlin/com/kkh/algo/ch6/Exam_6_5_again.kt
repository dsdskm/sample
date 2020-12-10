package com.kkh.algo.ch6


var m: Int = 0
var n: Int = 0
var ARR: Array<Array<Int>> = emptyArray()
var check_arr: Array<Boolean> = emptyArray()


@JvmOverloads
fun main() {

    // 친구 여부가 주어진다
    // n = 학생의 수, m = 친구 쌍의 수, arr=쌍 배열
    // m = arr.size
    // 모든 학생을 친구끼리만 짝지어줄 수 있는 방법

    /*
    n = 2
    m = 1
    ARR = arrayOf(arrayOf(0,1))
    check_arr = arrayOf(false,false)
    */

    /*
    n = 4
    m = 6
    ARR = arrayOf(
        arrayOf(0, 1),
        arrayOf(1, 2),
        arrayOf(2, 3),
        arrayOf(3, 0),
        arrayOf(0, 2),
        arrayOf(1, 3)
    )
    check_arr = arrayOf(
        false, false, false, false
    )
    */
    n = 6
    m = 10
    ARR = arrayOf(
        arrayOf(0, 1),
        arrayOf(0, 2),
        arrayOf(1, 2),
        arrayOf(1, 3),
        arrayOf(1, 4),
        arrayOf(2, 3),
        arrayOf(2, 4),
        arrayOf(3, 4),
        arrayOf(3, 5),
        arrayOf(4, 5)
    )
    check_arr = arrayOf(
        false, false, false, false, false, false
    )

    /*
    0,1	1,2	X
    0,1	2,3	O       =>
    0,1	3,0	X
    0,1	0,2	X
    0,1	1,3	X
    1,2	2,3	X
    1,2	3,0	O       =>
    1,2	0,2	X
    1,2	1,3	X
    2,3	3,0	X
    2,3	0,2	X
    2,3	1,3	X
    3,0	0,2	X
    3,0	1,3	X
    0,2	1,3	O       =>
     */
    print("ret ${solve()}")
}

fun solve(): Int {
    for (i in 0 until ARR.size) {
        var x = ARR[i][0]
        var y = ARR[i][1]
        check_arr[x] = true
        check_arr[y] = true
        println("$x,$y")
        solution(i + 1)
        check_arr[x] = false
        check_arr[y] = false
    }
    return sum
}

var sum = 0
fun solution(index: Int) {
    // 모든 체크가 끝났으면
    var all_checked = true
    for (i in 0 until check_arr.size) {
        if (!check_arr[i]) {
            all_checked = false
        }
    }
    println("all_checked $all_checked")
    if (all_checked) {
        sum++
        return
    }

    for (i in index until ARR.size) {
        var x = ARR[i][0]
        var y = ARR[i][1]
        println("   $x,$y check_arr[x] ${check_arr[x]} check_arr[y] ${check_arr[y]}")
        if (check_arr[x] || check_arr[y]) {
            //println(" continue")
            continue
        }

        check_arr[x] = true
        check_arr[y] = true
        solution(i + 1)
        check_arr[x] = false
        check_arr[y] = false
    }
}
