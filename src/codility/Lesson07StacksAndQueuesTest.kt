package codility

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Lesson07StacksAndQueuesTest {

    @ParameterizedTest
    @CsvSource(value = [
        "{[()()]}; 1",
        "([)()]; 0",
        "([)]; 0",
        "([{}]); 1",
        "([{}]; 0",
        "()[]{}; 1",
        "})][({; 0"
    ], delimiter = ';')
    fun isProperlyNested(nestedString : String, expected: Int) {
        assertEquals(expected, Lesson07StacksAndQueues().isProperlyNested(nestedString))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "4, 3, 2, 1, 5; 0, 1, 0, 0, 0; 2",
        "4, 3; 0, 1; 2",
        "4, 3; 1, 0; 1",
        "0, 1000000000; 1, 0; 1",
        "0; 1; 1",
        "1000000000; 0; 1",
        "3, 5, 2; 1, 0, 0; 2",
        "3, 5, 2, 1; 1, 0, 0, 1; 3",
        "1000000000, 999999999; 1, 0; 1",
    ], delimiter = ';')
    fun numberOfSurvivingFish(sizes: String, directions: String, expected: Int) {
        assertEquals(expected, Lesson07StacksAndQueues().numberOfSurvivingFish(Util().toIntArray(sizes), Util().toIntArray(directions)))
    }

    @ParameterizedTest
    @CsvSource(value = [
        "(()()); 1",
        "(()(())()); 1",
        "(); 1",
        ")(; 0",
        "); 0",
        "(; 0",
        "()); 0",
        "((()(())()))(); 0"
    ], delimiter = ';')
    fun isProperlyNestedRegularParentheses(nestedString : String, expected: Int) {
        assertEquals(expected, Lesson07StacksAndQueues().isProperlyNestedRegularParentheses(nestedString))
    }

    @Test
    fun isProperlyNestedRegularParentheses() {
        assertEquals(1, Lesson07StacksAndQueues().isProperlyNestedRegularParentheses(""))
    }
}