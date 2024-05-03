class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val num1 = version1.split(".").map { it.toInt() }
        val num2 = version2.split(".").map { it.toInt() }
        
        var i = 0
        var j = 0
        while(i < num1.size || j < num2.size) {
            val n1 = if (i < num1.size) num1[i] else 0
            val n2 = if (j < num2.size) num2[j] else 0
            
            if (n1 < n2) {
                return -1
            } else if (n1 > n2) {
                return 1
            }
            i++
            j++
        }
        return 0
    }
}
