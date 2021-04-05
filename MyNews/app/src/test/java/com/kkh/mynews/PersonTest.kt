package com.kkh.mynews

import com.kkh.mynews.mockito.Person
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class PersonTest {
    @Test
    fun test(){
        val p = mock(Person::class.java)
        assert(p!=null)
        `when`(p.name).thenReturn("KIM")
        `when`(p.age).thenReturn(88)

        assert("KIM" == p.name)
        assert(99 == p.age)


    }
}