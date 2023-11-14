class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val map = Array<IntArray>(26) {
            IntArray(s.length) { 0 }
        }
        for ((index, c) in s.withIndex()) {
            if (index == 0) {
                map[c - 'a'][index] = 1
                continue
            }
                
            for (i in 0 until map.size) {
                map[i][index] = map[i][index - 1]
                if (i == (c - 'a')) map[i][index]++
            }
        }
        
        //val set = mutableSetOf<String>()
        val set = BooleanArray(26 * 26 * 26) { false }
        var count = 0
        
        for (i in 1 until (s.length - 1)) {
            for (j in 0..25) {
                //0~ i-1
                val left = map[j][i-1]
                //s.lenght - 1 ~ i + 1
                val right = map[j][s.length - 1] - map[j][i]
                if (left == 0 || right == 0) continue
                
                if (set[getIndex('a'+j, s[i], 'a'+j)]) continue
                
                set[getIndex('a'+j, s[i], 'a'+j)] = true
                count++
                 
            }
        }
        return count
    }


    fun countPalindromicSubsequence_(s: String): Int {
        //val set = mutableSetOf<String>()
        val set = BooleanArray(26 * 26 * 26) { false }
        var count = 0
        
        val map = mutableMapOf<Char, Int>()
        for ((index, c) in s.withIndex()) {
            map[c] = index
        }
        
        for (i in 0 until (s.length - 2)) {
            for (j in (i + 1) until (s.length - 1)) {
                if (set[getIndex(s[i], s[j], s[i])]) {
                    continue
                }
                
                val nextIndex = map[s[i]] ?: continue
                if (nextIndex > j) {
                    set[getIndex(s[i], s[j], s[i])] = true
                    count++
                }

                /*
                for (k in (j+1) until s.length) {
                    if (s[k] == s[i]) {
                        set.add("" + s[i] + s[j] + s[i])
                        break;
                    }
                }
                */
            }
        }
        return count
    }
    
    private fun getIndex(c0: Char, c1: Char, c2: Char): Int {
        return (c0 - 'a') * 26 * 26 + (c1 - 'a') * 26 + (c2 - 'a')
    }
}
