package com.kkh.sample.kotlin.recipe7

// 객체를 사용하기 전에 생성자 인자만으로 할 수 없는 초기화 작업을 한다
// apply는 this를 인자로 전달하고 this를 리턴하는 확장 함수

class Officer {
    var name: String? = null
    var type: String? = null
}


@JvmOverloads
fun main() {
    var officer = save(Officer())
    println(officer.name)
    println(officer.type)
}

fun save(officer: Officer) = officer.apply {
    name = "ABC"
    type = "TYPE"
}