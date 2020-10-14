package codility

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Lesson02ArraysTest {

    @ParameterizedTest
    @CsvSource(value = [
        "3, 8, 9, 7, 6; 3; 9, 7, 6, 3, 8",
        "0, 0, 0; 1; 0, 0, 0",
        "1, 2, 3, 4; 4; 1, 2, 3, 4",
        "5, 4, 3, 2, 1; 0; 5, 4, 3, 2, 1"
    ], delimiter = ';')
    fun rotate(original: String, rotation: Int, expected: String) {
        val originalArray = Util().toIntArray(original)
        assertTrue(Util().toIntArray(expected).contentEquals(Lesson02Arrays().rotate(originalArray, rotation)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "9, 3, 9, 3, 9, 7, 9; 7",
        "1, 2, 3, 3, 2, 1, 4; 4"
    ], delimiter = ';')
    fun findLoneliestNumber(original: String, expected: Int) {
        assertEquals(expected, Lesson02Arrays().findLoneliestNumber(Util().toIntArray(original)))
    }
}