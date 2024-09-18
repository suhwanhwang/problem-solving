class Solution {
    /*
    fun largestNumber(nums: IntArray): String {
        return nums
            .map { it.toString() }
            .sortedWith(Comparator { n1, n2 ->
                var i = 0
                var j = 0
                var num = n1[0]
                
                while (i < n1.length || j < n2.length) {
                    val c1 = if (i < n1.length) n1[i] else num
                    val c2 = if (j < n2.length) n2[j] else num

                    if (c1 == c2) {
                        num = c1
                    } else if (c1 > c2) {
                        return@Comparator -1
                    } else if (c1 < c2) {
                        return@Comparator 1
                    }
                    i++
                    j++
                }
                0
            }).joinToString("")
    }
    */
    fun largestNumber(nums: IntArray): String {
        return nums
            .map { it.toString() }
            .sortedWith { n1, n2 ->
                (n2 + n1).compareTo(n1 + n2)
            }.joinToString("")
            .takeIf {
                it[0] != '0'
            } ?: "0"
    }
}
