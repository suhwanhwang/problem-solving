class Solution {
    fun totalMoney(n: Int): Int {
        var total = 0
        var start = 0
        for (i in 0..(n-1)) {
            if (i % 7 == 0) {
                start++
            }
            
            total += start + (i % 7)
        }
        return total
    }
}
