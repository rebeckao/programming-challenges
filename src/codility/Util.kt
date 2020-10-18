package codility

class Util {
    fun toIntArray(array: String) : IntArray {
        return array.split(", ")
                .map { Integer.parseInt(it) }
                .toIntArray()
    }
}

