package codility

class Lesson02Arrays {
    fun rotate(A: IntArray, K: Int): IntArray {
        val size = A.size
        val newArray = IntArray(size)
        for (position in 0 until size) {
            val newPosition = (position + K) % size
            newArray[newPosition] = A[position]
        }
        return newArray
    }

    // För långsam och hade fel på en uppgift!
    fun findLoneliestNumber(A: IntArray): Int {
        return A.groupBy { it }.minByOrNull { it.value.size }?.key ?: 0
    }
}