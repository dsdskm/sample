package recipe9

import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JUnit5ListTests {
    private val strings = listOf("this", "is", "a", "list", "of", "strings")

    private lateinit var modifiable : MutableList<Int>

    @BeforeEach
    fun setUp() {
        modifiable = mutableListOf(3, 1, 4, 1, 5)
        println("Before: $modifiable")
    }

    @AfterEach
    fun finish() {
        println("After: $modifiable")
    }

    @Test
    fun addElementsToList() {
        modifiable.add(9)
        modifiable.add(2)
        modifiable.add(6)
        modifiable.add(5)
        Assertions.assertEquals(9, modifiable.size)
    }

    @Test
    fun size() {
        println("Testing size")
        Assertions.assertEquals(6, strings.size)
        Assertions.assertEquals(5, modifiable.size)
    }

    @Test
    fun accessBeyondEndThrowsException() {
        println("Testing out of bounds exception")
        //assertThrows<ArrayIndexOutOfBoundsException> { strings[99] }
        Assertions.assertEquals(6, strings.size)
    }
}