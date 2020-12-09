package com.kkh.sample.kotlin.recipe5

data class Golfer(val score: Int, val first: String, val last: String)

val golfers = listOf(
    Golfer(70, "Jack", "Nicklaus"),
    Golfer(68, "Tom", "Waston"),
    Golfer(68, "Bubba", "Waston"),
    Golfer(70, "Tiger", "Woods"),
    Golfer(58, "Ty", "Webb")
)


@JvmOverloads
fun main() {
    val sorted = golfers.sortedWith(
        compareBy({ it.score }, { it.last }, { it.first })
    )

    println(sorted)

    var comparator = compareBy<Golfer>(Golfer::score).thenBy(Golfer::last).thenBy(Golfer::first)
    golfers.sortedWith(comparator).forEach(::println)

}