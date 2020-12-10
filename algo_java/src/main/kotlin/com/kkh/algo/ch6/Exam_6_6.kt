package com.kkh.algo.ch6

//https://hini7.tistory.com/26
val coverType = arrayOf(
    arrayOf(arrayOf(0, 0), arrayOf(1, 0), arrayOf(0, 1)),
    arrayOf(arrayOf(0, 0), arrayOf(0, 1), arrayOf(1, 1)),
    arrayOf(arrayOf(0, 0), arrayOf(1, 0), arrayOf(1, 1)),
    arrayOf(arrayOf(0, 0), arrayOf(1, 0), arrayOf(1, -1))
)

@JvmOverloads
fun main() {
    /*
    게임판 덮기
    H x W
    검은칸 흰칸으로 구성
    모든 흰 칸을 세칸짜리 L자 모양블록으로 덮고 싶다
    게임 판이 주어질때 이를 덮는 방법의 수

     */
    /*
    println(
        cover(
            arrayOf(
                arrayOf(1, 0, 0, 0, 0, 0, 1),
                arrayOf(1, 0, 0, 0, 0, 0, 1),
                arrayOf(1, 1, 0, 0, 0, 1, 1)
            )
        )
    )

     */
    println(
        cover(
            arrayOf(
                arrayOf(1, 0, 0, 0, 0, 0, 1),
                arrayOf(1, 0, 0, 0, 0, 0, 1),
                arrayOf(1, 1, 0, 0, 1, 1, 1)
            ), " "
        )
    )

    /*
    println(cover(
         arrayOf(
             arrayOf(1,1,1,1,1,1,1,1,1,1),
             arrayOf(1,0,0,0,0,0,0,0,0,1),
             arrayOf(1,0,0,0,0,0,0,0,0,1),
             arrayOf(1,0,0,0,0,0,0,0,0,1),
             arrayOf(1,0,0,0,0,0,0,0,0,1),
             arrayOf(1,0,0,0,0,0,0,0,0,1),
             arrayOf(1,0,0,0,0,0,0,0,0,1),
             arrayOf(1,1,1,1,1,1,1,1,1,1)
         )
     ))

     */
}


fun set(board: Array<Array<Int>>, y: Int, x: Int, type: Int, delta: Int, space: String): Boolean {
    var ok = true

    /*
    한점을 기준으로 세 가지 방법으로 채우는게 가능하다
    O O     O O     O X
    O X     X o     O O
     */
    for (i in 0 until 3) {
        val ny = y + coverType[type][i][0]
        val nx = x + coverType[type][i][1]
        if (ny < 0 || ny >= board.size || nx < 0 || nx >= board[0].size) {
            ok = false
        } else {
            board[ny][nx] += delta
            if (board[ny][nx] > 1) {
                ok = false
            }
        }
    }

    return ok
}

fun cover(board: Array<Array<Int>>, space: String): Int {
    var y = -1
    var x = -1
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 0) {
                y = i
                x = j
                break
            }
        }
        if (y != -1) {
            break
        }
    }
    println("$space x:$x y:$y")
    if (y == -1) {
        return 1
    }

    var ret = 0
    // 덮는 방법이 4가지
    for (type in 0 until 4) {
        if (set(board, y, x, type, 1, "$space ")) {
            ret += cover(board, "$space ")
        }
        println("$space ret : $ret")
        set(board, y, x, type, -1, "$space ")
    }
    return ret
}
