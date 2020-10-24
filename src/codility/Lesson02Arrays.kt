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

    fun findLoneliestNumber(A: IntArray): Int {
        val occurrences = HashMap<Int, Int>()
        for (element in A) {
            occurrences[element] = occurrences.getOrDefault(element, 0) + 1
        }
        for (occurrence in occurrences.entries) {
            if (occurrence.value % 2 != 0) {
                return occurrence.key
            }
        }
        return -1
    }

    fun findLoneliestNumberStupid(A: IntArray): Int {
        var result = 0
        for (element in A) {
           result = result.xor(element)
        }
        return result
    }
}