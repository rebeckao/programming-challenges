package drunkardswalk

import java.lang.Integer.max
import java.util.stream.Collectors.groupingBy
import kotlin.math.roundToInt
import kotlin.random.Random

class MovieGoers {

    fun asHistogram(data: List<Int>) = data
        .stream()
        .collect(groupingBy { it })
        .entries
        .map { Pair(it.key, it.value.size) }
        .toMap()

    fun printHistogram(histogram: Map<Int, Int>) {
        val max = histogram.keys.maxOrNull() ?: 0
        for (i in 0..max) {
            print("${i.toString().padStart(4, ' ')}:${"".padStart(histogram.getOrDefault(i, 0) / 10, 'I')}\n")
        }
    }

    fun changesInTheLeadBulkSimulation(numberOfMoviePairs: Int): List<Int> {
        return (0 until numberOfMoviePairs)
            .map { numberOfChangesOfTheLead(20_000) }
    }

    private fun numberOfChangesOfTheLead(numberOfMovieGoers: Int): Int {
        val movieGoers = intArrayOf(0, 0)
        var movieInTheLead = flipCoin()
        var changesInTheLead = 0
        for (i in 0 until numberOfMovieGoers - 1) {
            val currentMovie = flipCoin()
            movieGoers[currentMovie]++
            if (currentMovie != movieInTheLead && movieGoers[currentMovie] > movieGoers[movieInTheLead]) {
                changesInTheLead++
                movieInTheLead = currentMovie
            }
        }
        return changesInTheLead
    }

    fun percentageOfTimeSpentInLeadBulkSimulation(numberOfMoviePairs: Int): List<Int> {
        return (0 until numberOfMoviePairs)
            .map { percentageOfTimeSpentInLead(20_000) }
    }

    private fun percentageOfTimeSpentInLead(numberOfMovieGoers: Int): Int {
        val movieGoers = intArrayOf(0, 0)
        val timeInTheLead = intArrayOf(0, 0)
        var movieInTheLead = flipCoin()
        timeInTheLead[movieInTheLead]++
        for (i in 0 until numberOfMovieGoers - 1) {
            val currentMovie = flipCoin()
            movieGoers[currentMovie]++
            if (currentMovie != movieInTheLead && movieGoers[currentMovie] > movieGoers[movieInTheLead]) {
                movieInTheLead = currentMovie
            }
            timeInTheLead[movieInTheLead]++
        }
        val mostTimeInTheLead = max(timeInTheLead[0], timeInTheLead[1])
        return (mostTimeInTheLead * 10.0 / numberOfMovieGoers).roundToInt()
    }

    private fun flipCoin(): Int {
        return Random.nextInt(2)
    }
}