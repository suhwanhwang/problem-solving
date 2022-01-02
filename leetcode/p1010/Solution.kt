class Solution {
    fun numPairsDivisibleBy60(time: IntArray): Int {
        val map = IntArray(60)
        
        for (t in time) {
            map[t % 60]++;
        }
        
        var numPairs = map[0] * (map[0] - 1) / 2 + map[30] * (map[30] - 1) / 2
        for (i in 1 until 30) {
            numPairs += map[i] * map[60 - i]
        }
        return numPairs
    }
}
