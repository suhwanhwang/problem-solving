class Solution {
    fun maxProduct(words: Array<String>): Int {
        
        val bitMap = IntArray(words.size) {
            i -> getBit(words[i])
        }
        //println(bitMap.toList())
        var max = 0
        for (i in 0..words.size - 2) {
            for (j in (i + 1)..(words.size - 1)) {
                if (bitMap[i] and bitMap[j] == 0) {
                    max = Math.max(max, words[i].length * words[j].length)
                }
            }
        }
        return max
    }
    
    private fun getBit(s: String):Int {
        var result = 0
        for(c in s) {
            result = result or (1 shl (c - 'a'))
        }
        return result
    }
}
