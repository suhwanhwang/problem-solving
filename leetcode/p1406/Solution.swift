class Solution {
    private var dp = [[Int]]()
    func stoneGameIII(_ stoneValue: [Int]) -> String {
        let n = stoneValue.count
        dp = Array(repeating: Array(repeating: -1, count: n), count: 2)
        
        let sum = stoneValue.reduce(0, +)

        let alice = helper(stoneValue, 0, 0)
        let bob = sum - alice

        print("\(sum) = \(alice) + \(bob)")

        if alice == bob {
            return "Tie"
        } else if alice > bob {
            return "Alice"
        } else {
            return "Bob"
        }
    }

    private func helper(_ stoneValue: [Int], _ player: Int, _ index: Int) -> Int {
        guard index < stoneValue.count else {
            return 0
        }
        
        if dp[player][index] != -1 {
            return dp[player][index]
        }

        var sum = 0
        var res = (player == 1 ? 5 * 10000 * 1000 : -5 * 10000 * 100000);
        for len in 1...3 {
            if index + len - 1 >= stoneValue.count {
                break
            }
            sum += stoneValue[index + len - 1]

            if player == 0 {
                res = max(res, sum + helper(stoneValue, 1, index + len))
            } else {
                res = min(res, helper(stoneValue, 0, index + len))
            }
        }
        dp[player][index] = res
        return res
    }
}
