class Solution {
    /*
    fun hasAllCodes(s: String, k: Int): Boolean {
        val codeSet = HashSet(getCodes(k))
        //println(codeSet)
        for (i in 0..(s.length - k)) {
            val sub = s.substring(i, i + k)
            codeSet.remove(sub)
        }
        return codeSet.isEmpty()
    }
    
    private fun getCodes(k: Int): Set<String> {
        val set = mutableSetOf<String>()
        
        for (i in 0..((1 shl k) - 1)) {
            var num = i
            val sb = StringBuilder()
            for (j in 0 until k) {
                if (num and (1 shl j) == (1 shl j)) {
                    sb.append('1')
                } else {
                    sb.append('0')
                }
            }
            set.add(sb.toString())
        }
        return set
    }
    */
 
    fun hasAllCodes(s: String, k: Int): Boolean {
        val numSet = mutableSetOf<Int>()
        for (i in 0..(s.length - k)) {
            val sub = s.substring(i, i + k)
            numSet.add(convertInt(sub))
        }
        
        for (n in 0..((1 shl k) - 1)) {
            if (!numSet.contains(n)) {
                return false
            }
        }
        return true
    }
    
    private fun convertInt(s: String): Int {
        var num = 0
        for (c in s) {
            num = num shl 1
            num += (c - '0')
        }
        return num
    }
}
