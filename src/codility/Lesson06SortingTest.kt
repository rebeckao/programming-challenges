package codility

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Lesson06SortingTest {

    @ParameterizedTest
    @CsvSource(value = [
        "0, 1, 0, 1, 1; 2",
        "0; 1",
        "-1000000; 1",
        "1000000; 1",
        "1, 2, 3, 4, 5; 5",
    ], delimiter = ';')
    fun distinctValues(values: String, expected: Int) {
        assertEquals(expected, Lesson06Sorting().distinctValues(Util().toIntArray(values)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "-3, 1, 2, -2, 5, 6; 60",
        "0, 1, 0, 1, 1; 1",
        "1, 2, 3, 4, 5; 60",
        "2, 1, -5, -6, 3; 90",
        "1, 3, 3, 3, 1; 27",
        "-1, -2, -3; -6",
        "-5, -6, -4, -7, -10; -120"
    ], delimiter = ';')
    fun maximumProductOfTriplet(values: String, expected: Int) {
        assertEquals(expected, Lesson06Sorting().maximumProductOfTriplet(Util().toIntArray(values)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "1, 5, 2, 1, 4, 0; 11",
        "0; 0",
        "0, 2147483647; 1",
        "0, 0, 0; 0",
        "2, 2, 2; 3",
        "0, 1, 0; 2",
        "1, 0, 1; 3",
        "2147483647, 2147483647, 2147483647, 2147483647, 2147483647; 10"
    ], delimiter = ';')
    fun numberOfIntersectingPairs(discs: String, expected: Int) {
        assertEquals(expected, Lesson06Sorting().numberOfIntersectingPairsBruteForce(Util().toIntArray(discs)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "10, 2, 5, 1, 8, 20; 1",
        "10, 50, 5, 1; 0",
        "1, 2, 3; 0",
        "2, 2, 3; 1",
        "1, 2, 3, 4; 1",
        "1, 1, 4, 6; 0",
        "1, 1, 4, 5, 6; 1",
        "1, 1, 1; 1",
        "2147483647, 2147483647, 2147483647; 1",
        "-2147483648, -2147483648, -2147483648; 0",
        "-1, -1, -1; 0",
        "-1, 0, 1; 0",
        "7, 5, -1; 0",
        "-4, -5, 3, 0, 1; 0",
        "-2, 2, 2, 3; 1"
    ], delimiter = ';')
    fun hasTriangularTriplet(sideLengths: String, expected: Int) {
        assertEquals(expected, Lesson06Sorting().hasTriangularTripletBruteForce(Util().toIntArray(sideLengths)))
    }
}