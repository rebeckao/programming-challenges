package codility

class Lesson01Iterations {
    fun longestSequenceOfZeroes(N : Int) : Int {
        return N.toString(2)
                .trim('0')
                .split("1+".toRegex())
                .map{it.length}
                .max() ?: 0
    }
}