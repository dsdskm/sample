package com.kkh.sample.kotlin.recipe3

class OfficerControllerTests{

    // 초기화 비용에 따라 lateinit or lazy

    lateinit var value:String

    val value2:String by lazy {
        "VALUE"
    }


}
