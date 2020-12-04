package com.kkh.sample.kotlin.recipe2

var paramA = null

//var paramB:String = null
//var paramC:String = null
var paramD: String? = null
var paramE: String = "HELLO"    // 널 허용x
var paramF: String? = "HELLO"   // 널 허

class nullabilityTest {
}

class Person(val a: String, var b: String?)

// 자바의 메소드를 오버라이드 할 때 파라미터를 명시하지 않고 사용 가능
@JvmOverloads
fun main() {
    var p = Person("AAA", null)
    //val c = p.b.length error
    val c = p.b!!.length        // 널 아님. NPE 발생 가능
    val d = p.b?.length         // 널 아님. 널이면 널 리턴
    val e = p.b?.length ?: "NA"         // 널 이면 NA 리턴

    //paramE = null
    paramF = null
}