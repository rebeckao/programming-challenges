package codility

import kotlin.math.max

class Lesson06Sorting {
    fun distinctValues(values: IntArray): Int {
        val encounteredValues = HashSet<Int>()
        var numberOfDistinctValues = 0
        for (value in values) {
            if (!encounteredValues.contains(value)) {
                encounteredValues.add(value)
                numberOfDistinctValues++
            }
        }
        return numberOfDistinctValues
    }

    fun maximumProductOfTriplet(values: IntArray): Int {
        var maxValue = -1000
        var secondMaxValue = -1000
        var thirdMaxValue = -1000
        var minValue = 1000
        var secondMinValue = 10000
        for (value in values) {
            if (value >= maxValue) {
                thirdMaxValue = secondMaxValue
                secondMaxValue = maxValue
                maxValue = value
            } else if (value >= secondMaxValue) {
                thirdMaxValue = secondMaxValue
                secondMaxValue = value
            } else if (value > thirdMaxValue) {
                thirdMaxValue = value
            }

            if (value <= minValue) {
                secondMinValue = minValue
                minValue = value
            } else if (value < secondMinValue) {
                secondMinValue = value
            }
        }
//        return maxValue * max(secondMaxValue * thirdMaxValue, minValue * secondMinValue)
        return  max(maxValue * secondMaxValue * thirdMaxValue, maxValue * minValue * secondMinValue)
    }

    fun numberOfIntersectingPairsBruteForce(discs: IntArray): Int {
        val numberOfDiscs = discs.size
        var intersectingPairs = 0
        for (discIndex in 0..numberOfDiscs - 1) {
            for (otherDiscIndex in discIndex + 1 until numberOfDiscs) {
                if (discs[discIndex].toLong() + discs[otherDiscIndex].toLong() >= otherDiscIndex - discIndex) {
                    intersectingPairs++
                }
            }
        }
        if (intersectingPairs > 10_000_000) {
            return -1
        } else {
            return intersectingPairs
        }
    }

    fun hasTriangularTripletBruteForce(sides: IntArray): Int {
        val numberOfSides = sides.size
        for (sideIndex in 0 until (numberOfSides - 2)) {
            val side = sides[sideIndex].toLong()
            if (side <= 0) {
                continue
            }
            for (otherSideIndex in (sideIndex + 1) until (numberOfSides - 1)) {
                val otherSide = sides[otherSideIndex].toLong()
                if (otherSide <= 0) {
                    continue
                }
                for (thirdSideIndex in (otherSideIndex + 1) until numberOfSides) {
                    val thirdSide = sides[thirdSideIndex].toLong()
                    if (thirdSide <= 0) {
                        continue
                    }
                    if ((side + otherSide > thirdSide) && (otherSide + thirdSide > side) && (thirdSide + side > otherSide)) {
                        return 1
                    }
                }
            }
        }
        return 0
    }

}