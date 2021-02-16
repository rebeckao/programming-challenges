package drunkardswalk

class BirthdayProblem {
    fun numberOfGuests(probabilityOfSharedBirthday: Double, totalNumberOfDays: Int): Int {
        val probabilityOfNoSharedBirthday = 1 - probabilityOfSharedBirthday
        var numberOfGuests = 1
        var currentProbability = 1.0
        while (currentProbability > probabilityOfNoSharedBirthday) {
            numberOfGuests++
            val numberOfDaysLeftToChooseFrom = totalNumberOfDays - (numberOfGuests - 1)
            currentProbability *= numberOfDaysLeftToChooseFrom.toDouble() / totalNumberOfDays
        }
        return numberOfGuests
    }
}