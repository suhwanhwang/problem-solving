class Solution {
/*
[1,3,4,2,2]
      
floyd's cycle detection 

 0 1 2 3 4
[1,3,4,2,2]

     0 -> 1 -> 3 -> 2 -> 4
                    ^----|
slow                ^
fast                ^
        0 1 2 3 4
nums = [3,1,3,4,2]

        0 -> 3 -> 4 -> 2
             ^---------|
slow         ^
fast         ^
 */
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        slow = 0
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }
        return slow
    }
}
