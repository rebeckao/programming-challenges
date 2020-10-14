package codility

import java.lang.Math.abs

class Lesson03TimeComplexity {
    fun minimalNumberOfJumps(X: Int, Y: Int, D: Int): Int {
        return Math.ceil((Y - X) / D.toDouble()).toInt()
    }

    fun missingElement(A: IntArray): Int {
        val size = A.size
        val foundValues = IntArray(size + 1)
        for (value in A) {
            foundValues[value - 1] = 1
        }
        for (i in 0 until size + 1) {
            if (foundValues[i] == 0) {
                return i + 1
            }
        }
        return 0
    }

    fun minimalDifference(A: IntArray): Int {
        var sumBefore = 0
        var sumAfter = A.sum()
        var minimalDifference = abs(sumAfter) //glömde först abs här
        for (value in A) {
            sumBefore += value
            sumAfter -= value
            val currentDifference = abs(sumBefore - sumAfter)
            if (currentDifference < minimalDifference) {
                minimalDifference = currentDifference
            }
        }
        return minimalDifference
    }
}