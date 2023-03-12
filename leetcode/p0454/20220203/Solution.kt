class Solution {
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        val map12 = getSumMap(nums1, nums2)
        val map34 = getSumMap(nums3, nums4)
        
        var count = 0
        for (entry in map12) {
            count += map34.getOrDefault(-entry.key, 0) * entry.value
        }
        return count
    }
    
    private fun getSumMap(n1: IntArray, n2: IntArray): Map<Int, Int> {
        val map = mutableMapOf<Int, Int>()
        
        for (num1 in n1) {
            for (num2 in n2) {
                val sum = num1 + num2
                map[sum] = map.getOrDefault(sum, 0) + 1
            }
        }
        return map
    }
}
