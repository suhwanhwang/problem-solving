class Solution {
    /*
     1234567890
   1 0
   2 01
   3 0110
   4 01101001
   5 0110100110010110
    
    ab
    ab ~ab
    
    */
    fun kthGrammar_(n: Int, k: Int): Int {
        var list = listOf(0)
        
        for (i in 1..(n - 1)) {
            list = list + inv(list)
        }
        return list[k - 1]
    }
    
    private fun inv(list: List<Int>): List<Int> {
        return list.map {
            it xor 0x1
        }.toList()
    }

    fun kthGrammar(n: Int, k: Int): Int {
        var invCount = 0
        var curK = k - 1
        var curLen = 2.0.pow(n - 1).toInt()
        for (i in 2..n) {
            if (curK >= curLen / 2) {
                invCount += 1
                curK -= curLen / 2
            }
            
            curLen /= 2
        }
        return if (invCount % 2 == 0) 0 else 1
    }
}
