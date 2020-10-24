package codility

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class Lesson04CountingElementsTest {

    @ParameterizedTest
    @CsvSource(value = [
        "1, 3, 1, 4, 2, 3, 5, 4; 5; 6",
        "1; 1; 0",
        "1, 2, 3; 1; 0",
        "3, 2, 1; 3; 2",
        "3, 2, 3, 3, 2, 1; 3; 5",
        "3, 2, 3, 3, 2; 3; -1"
    ], delimiter = ';')
    fun earliestPath(leaves: String, pathLength: Int, expected: Int) {
        assertEquals(expected, Lesson04CountingElements().earliestPath(pathLength, Util().toIntArray(leaves)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "3, 4, 4, 6, 1, 4, 4; 5; 3, 2, 2, 4, 2",
        "1, 2, 1, 2, 1; 1; 3",
        "1, 2, 1, 2, 1; 2; 3, 2",
        "1; 1; 1",
        "2; 1; 0"
    ], delimiter = ';')
    fun countersAfterOperations(operations: String, numberOfCounters: Int, expected: String) {
        val actual = Lesson04CountingElements().countersAfterOperations(numberOfCounters, Util().toIntArray(operations))
        assertTrue(Util().toIntArray(expected).contentEquals(actual))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "1, 3, 6, 4, 1, 2; 5",
        "1, 2, 3; 4",
        "-1, -3; 1",
        "-1, -2, 0, 1, 3; 2",
        "0; 1",
        "-1; 1",
        "1000000; 1"
    ], delimiter = ';')
    fun smallestIntNotOccurring(ints: String, expected: Int) {
        assertEquals(expected, Lesson04CountingElements().smallestIntNotOccurring(Util().toIntArray(ints)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "4, 1, 3, 2; 1",
        "4, 1, 3; 0",
        "1; 1",
        "2; 0",
        "2, 3, 4, 5; 0"
    ], delimiter = ';')
    fun isPermutation(permutationCandidate: String, expected: Int) {
        assertEquals(expected, Lesson04CountingElements().isPermutation(Util().toIntArray(permutationCandidate)))
    }
}