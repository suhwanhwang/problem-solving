class Solution {
    func longestPalindromeSubseq(_ s: String) -> Int {
        var dp = Array(repeating: Array(repeating: -1, count: s.count), count:s.count)

        return helper(&dp, Array(s), 0, s.count - 1)
    }
  
    private func helper(_ dp: inout [[Int]], _ s: [Character], _ left: Int, _ right: Int) -> Int {
        if left > right {
            return 0
        }

        if left == right {
            return 1
        }

        if dp[left][right] != -1 {
            return dp[left][right]
        }

        if s[left] == s[right] {
            dp[left][right] = 2 + helper(&dp, s, left + 1, right - 1)
        } else {
            let leftCase = helper(&dp, s, left + 1, right)
            let rightCase = helper(&dp, s, left, right - 1)
            dp[left][right] = max(leftCase, rightCase)
        }

        return dp[left][right]
    }
}
