package com.kkh.sample.kotlin.recipe8

import kotlin.reflect.KProperty

// 어떤 클래스의 속성이 다른 클래스의 획득자와 설정자를 사용하게끔 만들고 싶다
// ReadOnlyProperty 또는 ReadWriteProperty를 구현

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' tp me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' int $thisRef")
    }
}

class Example {
    var p: String by Delegate()
}

@JvmOverloads
fun main(){
    val e = Example()
    println(e.p)
    e.p = "NEW"
}