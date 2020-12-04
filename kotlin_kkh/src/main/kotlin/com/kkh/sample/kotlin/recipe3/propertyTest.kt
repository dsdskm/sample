package com.kkh.sample.kotlin.recipe3

const val a = 10        // 컴파일 시간에 결정
val b = 20              // 런타임에 결정

// property : 값이 변경 될 수 있다
class ValClass {
    val name: String
        get() {
            return "AAA"
        }
}

class Task(val name: String) {    // 주 생성자에서 선언할때는 반드시 타입 정의를 해야한다
    var priority = 3    // 클래스 최상위
        set(value) {
            field = value.coerceIn(1..5)
        }

    val isLowPriority
        get() = priority < 3
}

var myTask = Task("AA").apply {
    //name="AA" // apply로 프로퍼티 초기화 못한다
    priority = 10
}

class Customer(){
    private var _message:List<String>? = null

    val message:List<String>
        get(){
            if(_message == null){
                _message = loadMessages()
            }
            return _message!!
        }

    private fun loadMessages():MutableList<String> = mutableListOf("AAAAA","BBBB","CCCC").also {
        println("loaded messages")
    }
}

class Customer2(){
    val message:List<String> by lazy {
        loadMessages()
    }

    private fun loadMessages():MutableList<String> = mutableListOf("AAAAA","BBBB","CCCC").also {
        println("loaded messages")
    }
}

@JvmOverloads
fun main(){
    print(myTask.priority)
}


