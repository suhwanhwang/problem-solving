class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        
        /*
        k = 6
         0  1  2  3  4 
        23, 2, 4, 6, 6
                  ^
sum     23 25 29 35
sum%k    2  4  1  0 
map 2 -> 0
    4 -> 1
    1 -> 2

        */
        val map = mutableMapOf<Int, Int>()
        var sum = 0
        map[0] = -1
        for (i in 0 until nums.size) {
            sum += nums[i]
            
            if (map.containsKey(sum % k)) {
                if (i - map[sum % k]!! >= 2) {
                    return true
                }
            } else {
                map[sum % k] = i
            }
        }
        return false
    }
}
