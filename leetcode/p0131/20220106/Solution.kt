class Solution {
    private val ans = mutableListOf<MutableList<String>>()
    fun partition(s: String): List<List<String>> {
        ans.clear()
        helper(s, 0, mutableListOf<String>())
        return ans
    }
    private fun helper(s: String, index: Int, pal: MutableList<String>) {
        if (index == s.length) {
            ans.add(ArrayList<String>(pal))
            return
        }
        
        for (i in (index + 1)..s.length) {
            val temp = s.substring(index, i)
            //println(temp)
            //println(isPal(temp))
            if (isPal(temp)) {
                pal.add(temp)
                helper(s, i, pal)
                pal.removeAt(pal.size - 1)
            }
        }
    }
    private fun isPal(s: String): Boolean {
        for (i in 0 .. (s.length / 2)) {
            if (s[i] != s[s.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}
