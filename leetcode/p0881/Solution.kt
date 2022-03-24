class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        //println(people.toList())
        var count = 0
        var left = 0
        var right = people.size - 1
        while (left <= right) {
            if (people[right] + people[left] > limit) {
                count++
                right--
            } else if (left == right || people[right] + people[left] <= limit) {
                count++
                left++
                right--
            }
        }
        return count
    }
}
