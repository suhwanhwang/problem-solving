class Solution {
    func maxUncrossedLines(_ nums1: [Int], _ nums2: [Int]) -> Int {
        var dp = Array(repeating: Array(repeating: -1, count: nums2.count), count: nums1.count)

        return helper(&dp, nums1, nums2, 0, 0)
    }

    private func helper(_ dp: inout [[Int]], _ nums1: [Int], _ nums2: [Int], _ index1: Int, _ index2: Int) -> Int {
        if index1 >= nums1.count || index2 >= nums2.count {
            return 0
        }

        if dp[index1][index2] != -1 {
            return dp[index1][index2]
        }
        // connect
        var maxCon = 0
        for j in index2..<nums2.count {
            if nums1[index1] == nums2[j] {
                maxCon = 1 + helper(&dp, nums1, nums2, index1 + 1, j + 1)
                break;
            }
        }
        maxCon = max(maxCon, helper(&dp, nums1, nums2, index1 + 1, index2))

        dp[index1][index2] = maxCon
        return maxCon
    }
}
