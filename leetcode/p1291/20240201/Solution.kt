class Solution {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val list = mutableListOf<Int>()
        val map = mutableMapOf<Int, Int>()
        var temp = 1
        for (i in 2..9) {
            temp = temp * 10 + i
            
            map[i] = temp
        }
        
        if (low > map[9]!!) return list
        
        val count = getNumCount(low)
    
        var num = map[count]!!
        while (num < low) {
            num = getNextSeq(num, map)
        }
        while (num <= high) {
            list.add(num)
            if (num == 123456789) break
            
            num = getNextSeq(num, map)
        }
        return list
    }
    
    private fun getNumCount(num: Int): Int {
        var cur = num
        var count = 0
        while (cur != 0) {
            count++
            cur /= 10
        }
        return count
    }
    
    private fun getNextSeq(num: Int, map: Map<Int, Int>): Int {
        var count = getNumCount(num)
        var curNum = num
        if (curNum % 10 == 9) {
            return map[count + 1]!!
        }
        
        count = getNumCount(curNum)
        var next = curNum
        var pow = 1
        for (i in 1..count) {
            next += pow
            pow *= 10
        }
        return next
    }
    
}
