class Solution {
     
    /*
     0123456
     3210123
        ^

    */
    
    
    fun countSubstrings(s: String): Int {
        
        var count = 0        
        for (i in 0 until s.length) {
            // odd
            for (j in 0 until s.length) {
                if (i - j < 0 || i + j >= s.length) break
                
                if (s[i - j] != s[i + j]) break
                count++
            }
            
            // even
            for (j in 0 until s.length) {
                if (i - j < 0 || i + j + 1 >= s.length) break
                
                if (s[i - j] != s[i + j + 1]) break
                count++
            }

        }
        return count
    }
}
