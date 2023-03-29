class Solution {
    func maxSatisfaction(_ satisfaction: [Int]) -> Int {
        let n = satisfaction.count
        var dp = Array(repeating: Array(repeating: -1, count: (n + 1)), count: n)
        return helper(satisfaction.sorted(), 0, 1, &dp)
    }

    private func helper(_ sat: [Int], _ index: Int, _ count: Int, _ dp: inout [[Int]]) -> Int {
        if index >= sat.count {
            return 0
        }
        if dp[index][count] != -1 {
            return dp[index][count]
        }

        let include = sat[index] * count + helper(sat, index + 1, count + 1, &dp)
        let exclude = helper(sat, index + 1, count, &dp)
        dp[index][count] = max(include, exclude)
        return dp[index][count]
    }
}
