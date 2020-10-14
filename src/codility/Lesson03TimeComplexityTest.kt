package codility

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Lesson03TimeComplexityTest {

    @ParameterizedTest
    @CsvSource(value = [
        "10, 85, 30, 3",
        "100000000, 1000000000, 10000001, 90"
    ])
    fun minimalNumberOfJumps(initialPosition: Int, targetPosition: Int, jumpLength: Int, expected: Int) {
        assertEquals(expected, Lesson03TimeComplexity().minimalNumberOfJumps(initialPosition, targetPosition, jumpLength))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "2, 3, 1, 5; 4",
        "6, 4, 3, 1, 9, 7, 2, 5, 10; 8"
    ], delimiter = ';')
    fun missingElement(array: String, expected: Int) {
        assertEquals(expected, Lesson03TimeComplexity().missingElement(Util().toIntArray(array)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "3, 1, 2, 4, 3; 1",
        "2, -3, 1, 5; 1",
        "6, 4, 3, 1, 9, 7, 2, 5, 10; 1",
        "-5; 5",
        "2000, 2000; 0",
        "2, -2; 0"
    ], delimiter = ';')
    fun minimalDifference(array: String, expected: Int) {
        assertEquals(expected, Lesson03TimeComplexity().minimalDifference(Util().toIntArray(array)))
    }
}