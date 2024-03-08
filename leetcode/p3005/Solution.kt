class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        return nums.groupBy { it }
        .map { it.value.size }
        .groupBy { it }
        .maxBy { it.key }
        .value
        .sum()
    }
}
