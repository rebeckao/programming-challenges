package codility

import java.util.Collections.max

class Lesson04CountingElements {
    fun earliestPath(pathLength: Int, leaves: IntArray): Int {
        val toBeCovered = BooleanArray(pathLength)
        for (time in leaves.indices) {
            toBeCovered[leaves[time] - 1] = true
            if (allCovered(toBeCovered)) {
                return time
            }
        }
        return -1
    }

    private fun allCovered(toBeCovered: BooleanArray): Boolean {
        for (position in toBeCovered) {
            if (!position) {
                return false
            }
        }
        return true
    }

    fun countersAfterOperations(numberOfCounters: Int, operations: IntArray) : IntArray {
        var counters = IntArray(numberOfCounters)
        var maxValue = 0
        for (operation in operations) {
            if (operation > numberOfCounters) {
                counters = IntArray(numberOfCounters) {maxValue}
            } else {
                counters[operation - 1]++
                val newValue = counters[operation - 1]
                if (newValue > maxValue) {
                    maxValue = newValue
                }
            }
        }
        return counters
    }

    fun smallestIntNotOccurring(ints: IntArray): Int {
        val occurrences = BooleanArray(1_000_001)
        occurrences[0] = true
        for (i in ints) {
            if (i > 0) {
                occurrences[i] = true
            }
        }
        for (occurrence in occurrences.indices) {
            if (!occurrences[occurrence]) {
                return occurrence
            }
        }
        return 0
    }

    fun isPermutation(permutationCandidate: IntArray): Int {
        val numberOfElements = permutationCandidate.size
        val occurrences = IntArray(numberOfElements + 1)
        for (element in permutationCandidate) {
            if (element == 0 || element > numberOfElements) {
                return 0
            }
            if (occurrences[element] == 1) {
                return 0
            } else {
                occurrences[element] = 1
            }
        }
        return 1
    }
}