class Solution {
    func arraySign(_ nums: [Int]) -> Int {
        return nums.map { 
            if $0 == 0 {
                return 0
            } else if $0 > 0 {
                return 1
            } else {
                return -1
            }
        }.reduce(1, *)
    }
}
