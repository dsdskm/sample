package com.kkh.sample.kotlin.recipe8

import kotlin.properties.Delegates

// 값이 초기화되기 전에 접근하면 예외를 던진다
var shouldNotBeNull:String by Delegates.notNull<String>()

@JvmOverloads
fun main(){
    println(shouldNotBeNull)
}