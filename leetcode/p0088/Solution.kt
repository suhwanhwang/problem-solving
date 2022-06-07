class Solution {
    fun merge_on(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val list = mutableListOf<Int>()
        var i = 0
        var j = 0
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i++])
            } else {
                list.add(nums2[j++])
            }
        }
        while (i < m) {
            list.add(nums1[i++])
        }
        while (j < n) {
            list.add(nums2[j++])
        }
        
        for (k in list.indices) {
            nums1[k] = list[k]
        }
    }
    
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]
                i--
            } else {
                nums1[k] = nums2[j]
                j--
            }
            k--
        }
    }
}
