package com.kkh.sample.kotlin.recipe11

import java.net.URL

// 클래스에서 단일 함수를 간단하게 호출하고 싶다.

data class AstroResult(val message: String, val number: Number)
data class Assignment(val craft: String, val name: String)

class AstroRequest {
    companion object {
        private const val ASTRO_URL = "http://api.open-notify.org/astros.json"
    }

    operator fun invoke(): AstroResult {
        val responseString = URL(ASTRO_URL).readText()
        return AstroResult("A",1)
    }
}

@JvmOverloads
fun main(){
    val request = AstroRequest()
    val result = request()
    println(result.message)
}