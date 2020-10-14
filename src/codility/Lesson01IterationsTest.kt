package codility

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Lesson01IterationsTest {

    @ParameterizedTest
    @CsvSource(value = [
        "1, 0",
        "1041, 5",
        "2147483647, 0",
        "12345, 6",
        "32, 0"
    ])
    fun longestSequenceOfZeroes(input: Int, expected: Int) {
        assertEquals(expected, Lesson01Iterations().longestSequenceOfZeroes(input))
    }
}