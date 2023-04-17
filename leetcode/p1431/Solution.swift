class Solution {
    func kidsWithCandies(_ candies: [Int], _ extraCandies: Int) -> [Bool] {
        let maxNum = candies.max()!
        var ans = [Bool]()
        for c in candies {
            if c + extraCandies >= maxNum {
                ans.append(true)
            } else {
                ans.append(false)
            }
        }
        return ans
    }
}
