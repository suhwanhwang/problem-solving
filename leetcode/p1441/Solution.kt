class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val ans = mutableListOf<String>()
        var index = 0
        for (i in 1..n) {
            if (index >= target.size) {
                break
            }
            
            if (target[index] == i) {
                ans.add("Push")
                index++
            } else if (target[index] > i) {
                ans.add("Push")
                ans.add("Pop")
            } else {
                // error
            }
        }
        return ans
    }
}
