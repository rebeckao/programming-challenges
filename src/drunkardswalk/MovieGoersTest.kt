package drunkardswalk

import org.junit.jupiter.api.Test

internal class MovieGoersTest {

    @Test
    fun changesInTheLead() {
        val movieGoers = MovieGoers()
        val changesInTheLead = movieGoers.changesInTheLeadBulkSimulation(10_000)
        val histogram = movieGoers.asHistogram(changesInTheLead)
        movieGoers.printHistogram(histogram)
    }

    @Test
    fun timeSpentInTheLead() {
        val movieGoers = MovieGoers()
        val changesInTheLead = movieGoers.percentageOfTimeSpentInLeadBulkSimulation(10_000)
        val histogram = movieGoers.asHistogram(changesInTheLead)
        movieGoers.printHistogram(histogram)
    }
}