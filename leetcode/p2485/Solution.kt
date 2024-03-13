class Solution {
    /*
    3 4 5 6
    6 5 4 3
    */
    fun pivotInteger(n: Int): Int {
        
        for (i in 1..n) {
            if (rangeSum(1, i) == rangeSum(i, n)) return i
        }
        return -1
    }
    
    private fun rangeSum(from: Int, to: Int): Int {
        return (to - from + 1) * (from + to) / 2
    }
}
