package codility

import java.util.*

class Lesson07StacksAndQueues {
    fun isProperlyNested(nestedString: String): Int {
        val openingParentheses = Stack<Char>()
        for (parenthesis in nestedString) {
            if (parenthesis == '(' || parenthesis == '[' || parenthesis == '{') {
                openingParentheses.add(parenthesis)
            } else {
                if (openingParentheses.isEmpty()) {
                    return 0
                }
                val matchingOpening = openingParentheses.pop()
                if (!(parenthesis == ')' && matchingOpening == '(')
                        && !(parenthesis == ']' && matchingOpening == '[')
                        && !(parenthesis == '}' && matchingOpening == '{')) {
                    return 0
                }
            }
        }
        return if (openingParentheses.isEmpty()) 1 else 0
    }

    fun numberOfSurvivingFish(sizes: IntArray, directions: IntArray): Int {
        var survivingFish = 0
        val fishesSwimingDownstream = Stack<Int>()
        for (fish in sizes.indices) {
            val currentSize = sizes[fish]
            if (directions[fish] == 1) {
                fishesSwimingDownstream.add(currentSize)
            } else {
                var isEaten = false
                while (!isEaten && !fishesSwimingDownstream.isEmpty()) {
                    if (fishesSwimingDownstream.peek() < currentSize) {
                        fishesSwimingDownstream.pop()
                    } else {
                        isEaten = true
                    }
                }
                if (!isEaten) {
                    survivingFish++
                }
            }
        }
        survivingFish += fishesSwimingDownstream.size
        return survivingFish
    }

    fun isProperlyNestedRegularParentheses(nestedString: String): Int {
        val openingParentheses = Stack<Char>()
        for (parenthesis in nestedString) {
            if (parenthesis == '(') {
                openingParentheses.add(parenthesis)
            } else {
                if (openingParentheses.isEmpty()) {
                    return 0
                }
                val matchingOpening = openingParentheses.pop()
                if (!(parenthesis == ')' && matchingOpening == '(')) {
                    return 0
                }
            }
        }
        return if (openingParentheses.isEmpty()) 1 else 0
    }

}