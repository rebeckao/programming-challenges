package drunkardswalk

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BirthdayProblemTest {

    @Test
    fun numberOfGuests() {
        assertEquals(23, BirthdayProblem().numberOfGuests(0.5, 365))
        assertEquals(498, BirthdayProblem().numberOfGuests(0.06, 2000_000))
    }
}