class Solution {
    private let MOD = 1000000007
    func ways(_ pizza: [String], _ k: Int) -> Int {
        var chars = [[Character]]()
        for p in pizza {
            chars.append(Array(p))
        }
        var dp = Array(repeating: Array(repeating: Array(repeating: -1, count: chars[0].count), count: chars.count), count: k+1)
        return helper(chars, k, 0, 0, &dp)
    }

    private func helper(_ pizza: [[Character]], _ k: Int, _ rowStart: Int, _ colStart: Int, _ dp: inout [[[Int]]]) -> Int{
        if k == 1 {
            for row in rowStart..<pizza.count {
                for col in colStart..<pizza[0].count {
                    if pizza[row][col] == "A" {
                        return 1
                    }
                }
            }
            return 0
        }
        
        if rowStart >= pizza.count || colStart >= pizza[0].count {
            return 0
        }

        if dp[k][rowStart][colStart] != -1 {
            return dp[k][rowStart][colStart]
        }

        var count = 0
        var rowHasApple = false
        for row in rowStart..<pizza.count {
            if !rowHasApple {
                for i in colStart..<pizza[0].count {
                    if pizza[row][i] == "A" {
                        rowHasApple = true
                        break
                    }
                }
            }
            if !rowHasApple {
                continue
            }

            count += helper(pizza, k - 1, row + 1, colStart, &dp)
            count %= MOD
        }

        var colHasApple = false
        for col in colStart..<pizza[0].count {
            if !colHasApple {
                for i in rowStart..<pizza.count {
                    if pizza[i][col] == "A" {
                        colHasApple = true
                        break
                    }
                }
            }
            if !colHasApple {
                continue
            }
            count += helper(pizza, k - 1, rowStart, col + 1, &dp)
            count %= MOD
        }
        dp[k][rowStart][colStart] = count
        return count
    }
}
