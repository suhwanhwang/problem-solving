class Solution {
    var dp = [Int]()
    func mostPoints(_ questions: [[Int]]) -> Int {
        dp = Array(repeating: -1, count: questions.count)
        return helper(questions, 0)
    }

    private func helper(_ questions: [[Int]], _ index: Int) -> Int {
        if index >= questions.count {
            return 0
        }

        if dp[index] != -1 {
            return dp[index]
        }

        // include
        let includeScore = questions[index][0]
        + helper(questions, index + questions[index][1] + 1)
        let excludeScore = helper(questions, index + 1)
        dp[index] = max(includeScore, excludeScore)
        return dp[index]
    }
}
