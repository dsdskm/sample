package com.kkh.sample.kotlin.recipe8

// 다른 클래스의 인스턴스가 포함된 클래스를 만들고, 그 클래스에 연산을 위임하고 싶다

interface Dialable {
    fun dial(number: String): String
}

class Phone : Dialable {
    override fun dial(number: String): String {
        println("dial number : $number");
        return number
    }


    interface Snappable {
        fun takePicture(): String
    }

    class Camera : Snappable {
        override fun takePicture() = "Taking picture"

    }
}

class SmartPhone(
    // 생성자에서 Phone과 Camera를 인스턴스화하고 모든 public 함수를 Phone과 Camera 인스턴스에 위임하도록 정의
    private val phone: Dialable = Phone(),
    private val camera: Phone.Snappable = Phone.Camera()
) : Dialable by phone, Phone.Snappable by camera

@JvmOverloads
fun main() {
    val smartPhone : SmartPhone = SmartPhone()

    println(smartPhone.dial("11111111"))
    println(smartPhone.takePicture())
}