class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split(".")
        val v2 = version2.split(".")
        val len = max(v1.size, v2.size)
        var index = 0
        while (index < len) {
            val num1 = if (index < v1.size) v1[index].toInt() else 0
            val num2 = if (index < v2.size) v2[index].toInt() else 0
            if (num1 < num2) {
                return -1
            } else if (num1 > num2) {
                return 1
            }
            index++
        }
        return 0
    }
}
