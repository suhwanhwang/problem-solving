class Solution {
    private var low = 0
    private var high = 0
    private var zero = 0
    private var one = 0
    private var dp = [Int]()

    func countGoodStrings(_ low: Int, _ high: Int, _ zero: Int, _ one: Int) -> Int {
        self.low = low
        self.high = high
        self.zero = zero
        self.one = one
        self.dp = Array(repeating: -1, count: high + 1)
        return helper(0)
    }

    private func helper(_ len: Int) -> Int {
        var before = 0

        if len > high {
            return 0
        } else if low <= len && len <= high {
            before = 1
        }
        
        if dp[len] != -1 {
            return dp[len]
        }

        var zeroCase = helper(len + zero)
        var oneCase = helper(len + one)
        dp[len] = (before + zeroCase + oneCase) % 1000000007
        return dp[len]
    }
}
