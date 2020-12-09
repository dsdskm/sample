package com.kkh.sample.kotlin.recipe5

import java.io.File.separator


// 기본적으로 코틀리 컬렉션은 불변
var numList = listOf(3, 1, 4, 1, 5, 9)   // 불변 리스트 생성
var numSet = setOf(3, 1, 4, 1, 5, 9)     // 불변 세트 생성
var map = mapOf(1 to "one", 2 to "two", 3 to "three")

var numList2 = mutableListOf(3, 1, 4, 1, 5, 9)   // 불변 리스트 생성
var numSet2 = mutableSetOf(3, 1, 4, 1, 5, 9)     // 불변 세트 생성
var map2 = mutableMapOf(1 to "one", 2 to "two", 3 to "three")

// 변경 가능한 리스트,세트,맵이 있을 때 해당 컬렉션의 읽기 전용 버전을 생송하고 싶다.
// 읽기 전용 컬렉션을 생성하여 기존 컬렉션을 할당

val keys = 'a'..'f'
val map3 = keys.associate { it to it.toString().repeat(5).capitalize() }

data class Product(val name: String, var price: Double, var onSale: Boolean = false)

@JvmOverloads
fun main() {
    println(map3)
    val param1 = Product("AAA", 1000.0)
    val param2 = Product("BBB", 55.0, onSale = true)
    val param3 = Product("CCC", 99.9, false)
    val products = listOf(param1,param2,param3)
    println(onSaleProducts_ifEmptyCollection(products))
    println(onSaleProducts_ifEmptyString(products))

}

fun onSaleProducts_ifEmptyCollection(products: List<Product>) =
    products.filter { it.onSale }
        .map {
            it.name
        }.ifEmpty { listOf("none") }.joinToString(separator = ",")
fun onSaleProducts_ifEmptyString(products: List<Product>) =
    products.filter { it.onSale }
        .map {
            it.name
        }.joinToString(separator = ",").ifEmpty { listOf("none") }

