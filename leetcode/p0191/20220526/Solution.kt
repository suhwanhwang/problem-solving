class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var count = 0
        var num = n
        while (num != 0) {
            if (num and 1 == 1) {
                count++
            }
            num = num ushr 1
        }
        return count
    }
}
