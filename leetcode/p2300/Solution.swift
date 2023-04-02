class Solution {
    func successfulPairs(_ spells: [Int], _ potions: [Int], _ success: Int) -> [Int] {
        let sortedPotions = potions.sorted()

        var ans = Array(repeating: 0, count: spells.count)
        for i in 0..<spells.count {
            let minValue = Int(ceil(Double(success) / Double(spells[i])))
            let index = lowerBound(sortedPotions, minValue)
            if sortedPotions[index] < minValue {
                ans[i] = 0
            } else {
                ans[i] = sortedPotions.count - index
            }
        }

        return ans
    }

    private func lowerBound(_ arr: [Int], _ target: Int) -> Int {
        var left = 0
        var right = arr.count - 1

        while left < right {
            var mid = left + (right - left) / 2

            if (arr[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }
}
