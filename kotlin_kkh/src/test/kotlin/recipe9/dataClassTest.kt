package recipe9

import org.junit.jupiter.api.Test
import java.time.LocalDate

// 코드를 부풀리지 않고 객체의 여러 속성을 체크

data class Book(val isbn: String, val title: String, val author: String, val published: LocalDate)

@Test
internal fun usedataclass(){

}
