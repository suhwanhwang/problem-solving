class SeatManager(n: Int) {
    private val emptySeat = TreeSet<Int>()
    init {
        for (i in 1..n) {
            emptySeat.add(i)
        }
    }
    
    fun reserve(): Int {
        val num = emptySeat.first() ?: -1
        emptySeat.remove(num)
        return num
    }

    fun unreserve(seatNumber: Int) {
        emptySeat.add(seatNumber)
    }

}
