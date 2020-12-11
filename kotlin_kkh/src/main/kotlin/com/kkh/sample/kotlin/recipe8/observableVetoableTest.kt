package com.kkh.sample.kotlin.recipe8

import kotlin.properties.Delegates

// 속성의 변경을 가로채서, 필요에 따라 변경을 거부
// 변경 감지에는 observable, 변경의 적용 여부 결정에는 vetoable

var watched: Int by Delegates.observable(1) { prop, old, new ->
    println("${prop.name} changed from $old to $new")
}

var checked: Int by Delegates.vetoable(0) { prop, old, new ->
    println("Trying to change ${prop.name} from $old to $new")
    new >= 0
}

@JvmOverloads
fun main(){
    watched = 10
    println("watched $watched")
    checked = 100
    println("checked $checked")
    checked = -1
    println("checked $checked")

}