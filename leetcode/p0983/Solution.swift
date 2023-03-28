/*

*/
class Solution {
    private var dp = [Int]()
    func mincostTickets(_ days: [Int], _ costs: [Int]) -> Int {
        dp = Array(repeating: -1, count: days.count)
        return dfs(days, costs, 0)
    }

    private func dfs(_ days: [Int], _ costs: [Int], _ index: Int) -> Int {
        if index >= days.count {
            return 0
        }

        if dp[index] != -1 {
            return dp[index]
        }

        let oneDay = costs[0] + dfs(days, costs, index + 1)
        let sevenDay = costs[1] + dfs(days, costs, getNextIndex(days, index, 7))
        let thirtyDay = costs[2] + dfs(days, costs, getNextIndex(days, index, 30))
        dp[index] = min(oneDay, sevenDay, thirtyDay)
        return dp[index]
    }

    private func getNextIndex(_ days:[Int], _ index: Int, _ after: Int) -> Int {
        let nextDay = days[index] + after
        for i in index..<days.count {
            if days[i] >= nextDay {
                return i
            } 
        }
        return days.count
    }
}
