package com.kkh.sample.kotlin.recipe8

// 여러 값이 들어 있는 map을 제공해 객체를 초기화

data class Project(val map: MutableMap<String, Any?>) {
    val name: String by map
    val priority: Int by map
    val completed: Boolean by map
}

@JvmOverloads
fun main() {
    val project = Project(
        mutableMapOf(
            "name" to "AAA",
            "priority" to 5,
            "completed" to true
        )
    )
    println(project.name)

}

