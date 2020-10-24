package codility

import java.lang.Math.min

class Lesson05PrefixSums {
    fun numberOfDivisibles(minimum: Int, maximum: Int, divisor: Int): Int {
        val minDiff = minimum % divisor
        val nextDivisibleAfterMin = if (minDiff == 0) {
            minimum
        } else {
            minimum + (divisor - minDiff)
        }
        val maxDiff = maximum % divisor
        val prevDivisibleBeforeMax = if (maxDiff == 0) {
            maximum
        } else {
            maximum - maxDiff
        }
        if (nextDivisibleAfterMin > prevDivisibleBeforeMax) {
            return 0
        }
        return (prevDivisibleBeforeMax - nextDivisibleAfterMin) / divisor + 1
    }

    fun minimalImpactFactors(nucleotides: String, starts: IntArray, ends: IntArray): IntArray {
        val mins = CharArray(starts.size) { 'T' }
        for (i in nucleotides.indices) {
            for (j in mins.indices) {
                if (starts[j] <= i && ends[j] >= i && nucleotides[i] < mins[j]) {
                    mins[j] = nucleotides[i]
                }
            }
        }
        val minNumbers = IntArray(mins.size)
        for (j in mins.indices) {
            val charMin = mins[j]
            minNumbers[j] = if (charMin == 'A') {
                1
            } else if (charMin == 'C') {
                2
            } else if (charMin == 'G') {
                3
            } else {
                4
            }
        }
        return minNumbers
    }

    fun minimalAverageSliceStartingIndexBruteForce(array: IntArray): Int {
        val numberOfElements = array.size
        val minAveragesByStartIndex = DoubleArray(numberOfElements - 1) { 10000.0 }
        val currentSumsByStartIndex = IntArray(numberOfElements - 1)
        for (i in array.indices) {
            for (j in 0..min(i, numberOfElements - 2)) {
                currentSumsByStartIndex[j] += array[i]
                if (i > j) {
                    val currentAverage = currentSumsByStartIndex[j] / (i - j + 1.0)
                    if (currentAverage < minAveragesByStartIndex[j]) {
                        minAveragesByStartIndex[j] = currentAverage
                    }
                }
            }
        }
        var minIndex = 0
        var minAverage = 10000.0
        for (i in 0 until numberOfElements - 1) {
            if (minAveragesByStartIndex[i] < minAverage) {
                minAverage = minAveragesByStartIndex[i]
                minIndex = i
            }
        }
        return minIndex
    }

    fun minimalAverageSliceStartingIndexOriginal(array: IntArray): Int {
        val numberOfElements = array.size
        var bestIndex = 0
        var sumFromIndex = array[0] + array[1]
        var globalMinAverage = sumFromIndex / 2.0
        var globalBestIndex = 0
        for (i in 2 until numberOfElements) {
            val newSum = sumFromIndex + array[i]
            val newAverageFromCurrentStart = newSum / (i - bestIndex + 1.0)
            val newAverageFromLast = (array[i - 1] + array[i]) / 2.0
            if (newAverageFromLast < newAverageFromCurrentStart) {
                bestIndex = i - 1
                sumFromIndex = array[i - 1] + array[i]
                if (newAverageFromLast < globalMinAverage) {
                    globalMinAverage = newAverageFromLast
                    globalBestIndex = bestIndex
                }
            } else if (newAverageFromCurrentStart < globalMinAverage) {
                globalMinAverage = newAverageFromCurrentStart
                globalBestIndex = bestIndex
            }
        }
        return globalBestIndex
    }


    fun minimalAverageSliceStartingIndex(array: IntArray): Int {
        val numberOfElements = array.size
        var bestIndex = 0
        var sumFromIndex = array[0] + array[1]
        var globalMinAverage = sumFromIndex / 2.0
        var globalBestIndex = 0
        for (i in 2 until numberOfElements) {
            val newSum = sumFromIndex + array[i]
            val newAverageFromCurrentStart = newSum / (i - bestIndex + 1.0)
            val newAverageFromLast = (array[i - 1] + array[i]) / 2.0
            if (newAverageFromLast < newAverageFromCurrentStart) {
                bestIndex = i - 1
                sumFromIndex = array[i - 1] + array[i]
                if (newAverageFromLast < globalMinAverage) {
                    globalMinAverage = newAverageFromLast
                    globalBestIndex = bestIndex
                }
            } else {
                sumFromIndex = newSum
                if (newAverageFromCurrentStart < globalMinAverage) {
                    globalMinAverage = newAverageFromCurrentStart
                    globalBestIndex = bestIndex
                }
            }
        }
        return globalBestIndex
    }

    fun numberOfPassingCars(cars: IntArray): Int {
        var goingEast = 0
        var passingPairs = 0
        for (car in cars) {
            if (car == 0) {
                goingEast++
            } else {
                passingPairs += goingEast
            }
            if (passingPairs >= 1_000_000_000) { // Missade detta först
                return -1
            }
        }
        return passingPairs
    }
}