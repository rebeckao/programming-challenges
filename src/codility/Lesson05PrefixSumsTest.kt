package codility

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

internal class Lesson05PrefixSumsTest {

    @ParameterizedTest
    @CsvSource(value = [
        "6, 11, 2, 3",
        "5, 10, 2, 3",
        "4, 9, 2, 3",
        "0, 3, 2, 2",
        "0, 0, 1, 1",
        "0, 1, 1, 2",
        "1, 1, 1, 1",
        "0, 2000000000, 2, 1000000001",
        "0, 2000000000, 2000000000, 2",
        "80, 82, 9, 1",
        "78, 80, 9, 0"
    ])
    fun numberOfDivisibles(minimum: Int, maximum: Int, divisor: Int, expected: Int) {
        assertEquals(expected, Lesson05PrefixSums().numberOfDivisibles(minimum, maximum, divisor))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "CAGCCTA; 2, 5, 0; 4, 5, 6; 2, 4, 1",
        "A; 0; 0; 1",
        "TAGC; 0; 0; 4"
    ], delimiter = ';')
    fun minimalImpactFactors(nucleotides: String, rawStarts: String, rawEnds: String, expected: String) {
        val actual = Lesson05PrefixSums().minimalImpactFactors(
                nucleotides,
                Util().toIntArray(rawStarts),
                Util().toIntArray(rawEnds)
        )
        assertTrue(actual.contentEquals(Util().toIntArray(expected)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "4, 2, 2, 5, 1, 5, 8; 1",
        "5, 1, 1; 1",
        "1, 3, 2, 2; 0",
        "-1, -3, -1, -3; 1",
        "-1, -2, 5, -2, -1; 0",
        "6, 1, 5, -1; 1",
        "10000, 10000; 0",
        "10000, -10000, 10000, 10000, -10000, 10000, -10000; 4",
        "0, 0; 0",
        "0, -10000, -1; 1",
        "1, -20, 1, 3, -22; 0",
        "10, 9, 8, 7, 6, 5; 4",
        "1, 2, -5, 0, -3, 0, -5; 2",
        "10, 10, -1, 2, 4, -1, 2, -1; 5"
    ], delimiter = ';')
    fun minimalAverageSliceStartingIndex(array: String, expected: Int) {
        assertEquals(expected, Lesson05PrefixSums().minimalAverageSliceStartingIndex(Util().toIntArray(array)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "0, 1, 0, 1, 1; 5",
        "1, 1, 0, 0; 0",
        "0, 0, 1, 1; 4",
        "0, 1; 1",
        "0, 0; 0",
        "1, 1; 0",
        "1; 0",
        "0; 0",
        "0, 1, 0, 1, 0; 3",
    ], delimiter = ';')
    fun numberOfPassingCars(cars: String, expected: Int) {
        Assertions.assertEquals(expected, Lesson05PrefixSums().numberOfPassingCars(Util().toIntArray(cars)))
    }
}