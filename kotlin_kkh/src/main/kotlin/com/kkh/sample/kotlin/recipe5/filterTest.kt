package com.kkh.sample.kotlin.recipe5

import java.time.LocalDate

// 여러 타입이 섞여 있는 컬렉션에서 특정 타입의 원소로만 구성된 새 컬렉션 생성

@JvmOverloads
fun main(){
    val list = listOf("a", LocalDate.now(),1,4,"b")
    val stringsOnly = list.filter{it is String}
    println(stringsOnly)

    val all = list.filterIsInstance<Any>()
    val strings = list.filterIsInstance<String>()
    val ints = list.filterIsInstance<Int>()
    val dates = list.filterIsInstance(LocalDate::class.java)

    println(all)
    println(strings)
    println(ints)
    println(dates  )

}