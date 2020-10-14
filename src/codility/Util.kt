package codility

class Util {
    fun toIntArray(array: String) : IntArray {
        return array.split(", ").map { it.toInt() }.toIntArray()
    }
}

