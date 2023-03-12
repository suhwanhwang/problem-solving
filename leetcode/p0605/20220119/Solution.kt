class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var max = 0
        
        for ((i, flower) in flowerbed.withIndex()) {
            if (flowerbed[i] == 1) {
                continue
            }
            val prev = if (i > 0) flowerbed[i - 1] else 0
            val next = if (i < flowerbed.size - 1) flowerbed[i + 1] else 0
            if (prev == 0 && next == 0) {
                flowerbed[i] = 1
                max++
            }
        }
        return n <= max
    }
}
