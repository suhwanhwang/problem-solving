class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = convert(version1)
        val v2 = convert(version2)
        val maxLen = Math.max(v1.size, v2.size)
        for (i in 0 until maxLen) {
            val num1 = if (i >= v1.size) 0 else v1[i]
            val num2 = if (i >= v2.size) 0 else v2[i]
            if (num1 == num2) continue
            
            return if (num1 < num2) -1 else 1
        }
        return 0
    }
    
    fun convert(v: String): List<Int> =
        v.split(".").map {
            it.toInt()
        }.toList()
}
