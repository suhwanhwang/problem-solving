class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val cumulative = mutableListOf<Int>()
        var cur = 0
        for (num in arr) {
            cur = cur xor num
            cumulative.add(cur)
        }
        
        
        val ans = mutableListOf<Int>()
        
        for (query in queries) {
            val left = if (query[0] == 0) 0 else cumulative[query[0] - 1]
            val right = cumulative[query[1]]
            
            ans.add(left xor right)
        }
        return ans.toIntArray()
    }
}

/*
0 0001  0001(1)
1 0011  0010(2)
2 0100  0110(6)
3 1000  1110(7)

0001 xor 0110 0111
*/
