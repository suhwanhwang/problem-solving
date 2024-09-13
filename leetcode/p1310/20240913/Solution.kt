class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val ans = mutableListOf<Int>()
        
        for (query in queries) {
            ans.add(getXOR(arr, query[0], query[1]))
        }
        return ans.toIntArray()
    }
    
    private fun getXOR(arr: IntArray, left: Int, right: Int): Int {
        var ans = 0
        for (i in left..right) {
            ans = ans xor arr[i]
        }
        return ans
    }
}
