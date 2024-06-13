class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        
        var move = 0
        for (i in 0 until seats.size) {
            move += abs(seats[i] - students[i])
        }
        return move
    }
}
