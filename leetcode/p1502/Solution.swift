class Solution {
    func canMakeArithmeticProgression(_ arr: [Int]) -> Bool {
        let sorted = arr.sorted()
        let diff = sorted[1] - sorted[0]
        for i in 2..<sorted.count {
            if diff != sorted[i] - sorted[i - 1] {
                return false
            }
        }
        return true
    }
}
