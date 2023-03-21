class Solution {
    func zeroFilledSubarray(_ nums: [Int]) -> Int {
        // 0000
        
        var prev = -1
        var count = 0

        for i in 0...nums.count {
            if i < nums.count && nums[i] == 0 {
                if prev == -1 {
                    prev = i
                }
            } else {
                if prev != -1 {
                    count += getCount(i - prev)
                    prev = -1
                }
            }
        }
        return count
    }

    private func getCount(_ n: Int) -> Int {
        return (n + 1) * n / 2
    }
}
