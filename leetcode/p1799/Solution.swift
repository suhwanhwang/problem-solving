class Solution {
    func maxScore(_ nums: [Int]) -> Int {
        var dp = Array(repeating: -1, count: (1 << nums.count))
        return helper(nums, 0, 0, &dp)
    }

    private func helper(_ nums: [Int], _ count: Int, _ mask: Int, _ dp: inout [Int]) -> Int {
        let n = nums.count
        if count == n {
            return 0
        }

        if dp[mask] != -1 {
            return dp[mask]
        }

        var maxS = 0
        for i in 0..<(n - 1) {
            for j in (i + 1)..<n {
                if mask & (1 << i) != 0 || mask & (1 << j) != 0 {
                    continue
                }
                let added = (1 << i) | (1 << j)
                let newMask = mask | added
                let score = (count / 2 + 1) * gcd(nums[i], nums[j]) + helper(nums, count + 2, newMask, &dp)

                maxS = max(maxS, score)
            }
        }
        dp[mask] = maxS
        return maxS
    }

    private func gcd(_ a: Int, _ b: Int) -> Int {
        return b == 0 ? a : gcd(b, a % b)
    }
}
