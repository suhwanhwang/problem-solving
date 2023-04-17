class Solution {
    func kidsWithCandies(_ candies: [Int], _ extraCandies: Int) -> [Bool] {
        guard let maxNum = candies.max() else { return [Bool]() }
        return candies.map { $0 + extraCandies >= maxNum }
    }
}
